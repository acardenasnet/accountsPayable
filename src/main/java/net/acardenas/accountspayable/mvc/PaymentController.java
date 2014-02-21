/*
 * ---------------------------------------------------------------------------
 *    COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *    All rights reserved.
 *
 *    The Copyright to the computer program(s) herein is the property of
 *    Alejandro Raul Cardenas
 *    The program(s) may be used and/or copied only with the written
 *    permission from Alejandro Cardenas, or in
 *    accordance with the terms and conditions stipulated in the
 *    agreement/contract under which the program(s) have been supplied.
 *    ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.mvc;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.dataservice.api.PaymentDataservice;
import net.acardenas.accountspayable.entity.Payment;
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
 * Created by acardenas on 2/20/14.
 */
@Controller
@RequestMapping("/payment")
public class PaymentController
{
    @Autowired
    private PaymentDataservice paymentDataservice;

    @Autowired
    private EventDataservice eventDataservice;

    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @RequestMapping("{accountPaymentId}")
    public String listPayments(@PathVariable("accountPaymentId") Integer accountPaymentId, ModelMap aModelMap)
    {
        LOG.debug("printList");
        aModelMap.addAttribute("payments", paymentDataservice.findWithNamedQuery(Payment.ALL));
        return "payment/list";
    }

    @RequestMapping("add")
    public String addPayment(Map<String, Object> map)
    {
        Payment myAccountPayable = new Payment();
        map.put("payment", myAccountPayable);
        return "payment/edit";
    }

    @RequestMapping("edit/{accountPayableId}")
    public String editAccountPayable(
            @PathVariable("accountPayableId") Integer anAccountPayableId,
            Map<String, Object> map)
    {
        Payment myAccountPayable = paymentDataservice.find(anAccountPayableId);
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("save/{eventId}")
    public String saveAccountPayable(@PathVariable("eventId") Integer anEventId,
                                     @ModelAttribute("payment") Payment anAccountPayable)
    {
        LOG.debug("saveAccountPayable");

        if (anAccountPayable.getId() != null)
        {
            paymentDataservice.update(anAccountPayable);
        }
        else
        {
            paymentDataservice.create(anAccountPayable);
        }

        LOG.debug("redirect account {}", anAccountPayable);
        return "redirect:/accountPayable/" + anEventId;
    }

    @RequestMapping("delete/{accountPayableId}")
    public String deleteAccountPayable(@PathVariable("accountPayableId") Integer anAccountPayableId)
    {
        paymentDataservice.delete(anAccountPayableId);
        return "redirect:/accountPayable/1";
    }

}
