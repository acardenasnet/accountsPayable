/*
 * ---------------------------------------------------------------------------
 *  COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *  All rights reserved.
 *
 *  The Copyright to the computer program(s) herein is the property of
 *  Alejandro Raul Cardenas
 *  The program(s) may be used and/or copied only with the written
 *  permission from Alejandro Cardenas, or in
 *  accordance with the terms and conditions stipulated in the
 *  agreement/contract under which the program(s) have been supplied.
 *  ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.mvc;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/event")
public class EventController
{
    @Autowired
    private EventDataservice eventDataservice;
    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String listEvents(ModelMap aModelMap)
    {
        LOG.debug("printList");
        aModelMap.addAttribute("events", eventDataservice.findWithNamedQuery(Event.ALL));
        return "event/event";
    }

    @RequestMapping("add")
    public String addEvent(Map<String, Object> map)
    {
        Event myEvent = new Event();
        map.put("event", myEvent);
        return "event/edit";
    }

    @RequestMapping("edit/{eventId}")
    public String editEvent(@PathVariable("eventId") Integer eventId, Map<String, Object> map)
    {
        Event myEvent = eventDataservice.find(eventId);
        map.put("event", myEvent);
        return "event/edit";
    }

    @RequestMapping("save")
    public String saveEvent(@ModelAttribute("event") Event aEvent)
    {
        if (aEvent.getId() != null)
        {
            eventDataservice.update(aEvent);
        }
        else
        {
            eventDataservice.create(aEvent);
        }
        return "redirect:/event";
    }

    @RequestMapping("delete/{eventId}")
    public String deleteEvent(@PathVariable("eventId") Integer eventId)
    {
        eventDataservice.delete(eventId);
        return "redirect:/event";
    }
}