package net.acardenas.accountspayable.mvc;

import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.dataservice.api.EventDataservice;
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
    private AccountPayableDataservice accountPayableDataservice;

    @Autowired
    private EventDataservice eventDataservice;

    private static final Logger LOG = LoggerFactory.getLogger(AccountsPayableController.class);

    @RequestMapping("{eventId}")
    public String listAccountsPayable(@PathVariable("eventId") Integer eventId, ModelMap aModelMap)
    {
        LOG.debug("printList");
        aModelMap.addAttribute("accountsPayable", accountPayableDataservice.findWithNamedQuery(AccountPayable.ALL));
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
        AccountPayable myAccountPayable = accountPayableDataservice.find(anAccountPayableId);
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("save/{eventId}")
    public String saveAccountPayable(@PathVariable("eventId") Integer anEventId,
                            @ModelAttribute("accountPayable") AccountPayable anAccountPayable)
    {
        LOG.debug("saveAccountPayable");
        Event myEvent = eventDataservice.find(anEventId);
        myEvent.getAccountsPayable().add(anAccountPayable);

        if (anAccountPayable.getId() != null)
        {
            accountPayableDataservice.update(anAccountPayable);
        }
        else
        {
            accountPayableDataservice.create(anAccountPayable);
        }

        eventDataservice.update(myEvent);
        LOG.debug("redirect account {}", anAccountPayable);
        return "redirect:/accountPayable/" + anEventId;
    }

    @RequestMapping("delete/{accountPayableId}")
    public String deleteAccountPayable(@PathVariable("accountPayableId") Integer anAccountPayableId)
    {
        accountPayableDataservice.delete(anAccountPayableId);
        return "redirect:/accountPayable/1";
    }
}
