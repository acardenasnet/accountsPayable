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

import net.acardenas.accountspayable.beans.api.AccountPayableService;
import net.acardenas.accountspayable.beans.api.EventService;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by acardenas on 2/7/14.
 */
@Controller
@RequestMapping("/accountPayable")
public class AccountsPayableController
{
    @Autowired
    private AccountPayableService accountPayableService;

    @Autowired
    private EventService eventService;

    private static final Logger LOG = LoggerFactory.getLogger(AccountsPayableController.class);

    @RequestMapping("{eventId}")
    public String listAccountsPayable(@PathVariable("eventId") Integer eventId, ModelMap aModelMap)
    {
        LOG.debug("listAccountsPayable for Event {}", eventId);
        Event myEvent = eventService.find(eventId);
        AccountPayable myAccountPayable = new AccountPayable();
        myAccountPayable.setEvent(myEvent);
        aModelMap.addAttribute("accountsPayable", accountPayableService.getList(myEvent));
        aModelMap.addAttribute("accountPayable", myAccountPayable);
        return "accountPayable/list";
    }

    @RequestMapping("add")
    public String addEvent(Map<String, Object> map)
    {
        AccountPayable myAccountPayable = new AccountPayable();
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("edit/{accountPayableId}")
    public String editAccountPayable(
            @PathVariable("accountPayableId") Integer anAccountPayableId,
            Map<String, Object> map)
    {
        AccountPayable myAccountPayable = accountPayableService.find(anAccountPayableId);
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("save")
    public String saveAccountPayable(@ModelAttribute("accountPayable") AccountPayable anAccountPayable)
    {
        LOG.debug("saveAccountPayable");
//        Event myEvent = eventDataservice.find(anEventId);
//        myEvent.getAccountsPayable().add(anAccountPayable);
        AccountPayable myAccountPayable = anAccountPayable;
        if (anAccountPayable.getId() != null)
        {
            accountPayableService.update(anAccountPayable);
        }
        else
        {
            myAccountPayable = accountPayableService.create(anAccountPayable);
        }

//        eventDataservice.update(myEvent);
        LOG.debug("redirect account {}", anAccountPayable);
        return "redirect:/accountPayable/" + myAccountPayable.getEvent().getId();
    }

    @RequestMapping("delete/{accountPayableId}")
    public String deleteAccountPayable(@PathVariable("accountPayableId") Integer anAccountPayableId)
    {
        int myEventiId = accountPayableService.find(anAccountPayableId).getEvent().getId();
        accountPayableService.delete(anAccountPayableId);
        return "redirect:/accountPayable/" 
                + myEventiId;
    }
}
