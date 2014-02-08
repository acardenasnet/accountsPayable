package net.acardenas.accountspayable.mvc;

import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
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
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by acardenas on 2/7/14.
 */
@Controller
@RequestMapping("/accountPayable")
public class AccountsPayableController
{
    @Autowired
    private AccountPayableDataservice accountPayableDataservice;
    private static final Logger LOG = LoggerFactory.getLogger(AccountsPayableController.class);

    @RequestMapping("{eventId}")
    public String listEvents(@PathVariable("eventId") Integer eventId, ModelMap aModelMap)
    {
        LOG.debug("printList");
        aModelMap.addAttribute("events", accountPayableDataservice.findWithNamedQuery(AccountPayable.ALL));
        return "accountPayable/list";
    }

    @RequestMapping("add")
    public String addEvent(Map<String, Object> map)
    {
        AccountPayable myAccountPayable = new AccountPayable();
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("edit/{eventId}")
    public String editEvent(@PathVariable("eventId") Integer eventId, Map<String, Object> map)
    {
        AccountPayable myAccountPayable = accountPayableDataservice.find(eventId);
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("save")
    public String saveEvent(@ModelAttribute("accountPayable") AccountPayable anAccountPayable)
    {
        if (anAccountPayable.getId() != null)
        {
            accountPayableDataservice.update(anAccountPayable);
        }
        else
        {
            accountPayableDataservice.create(anAccountPayable);
        }
        return "redirect:/accountPayable";
    }

    @RequestMapping("delete/{eventId}")
    public String deleteEvent(@PathVariable("eventId") Integer eventId)
    {
        accountPayableDataservice.delete(eventId);
        return "redirect:/accountPayable";
    }

}
