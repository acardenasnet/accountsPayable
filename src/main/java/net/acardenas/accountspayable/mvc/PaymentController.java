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

import net.acardenas.accountspayable.beans.api.AccountPayableService;
import net.acardenas.accountspayable.beans.api.PaymentService;
import net.acardenas.accountspayable.entity.AccountPayable;
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
    private PaymentService paymentService;

    @Autowired
    private AccountPayableService accountPayableService;

    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

    @RequestMapping("{accountPaymentId}")
    public String listPayments(@PathVariable("accountPaymentId") Integer accountPaymentId, ModelMap aModelMap)
    {
        LOG.debug("list payments for {}", accountPaymentId);

        AccountPayable myAccountPayable = accountPayableService.find(accountPaymentId);
        Payment myPayment = new Payment();
        myPayment.setAccountPayable(myAccountPayable);

        aModelMap.addAttribute("payments", paymentService.getList(myAccountPayable));
        aModelMap.addAttribute("payment", myPayment);
        return "payment/list";
    }

    @RequestMapping("add")
    public String addPayment(Map<String, Object> map)
    {
        Payment myPayment = new Payment();
        map.put("payment", myPayment);
        return "payment/edit";
    }

    @RequestMapping("edit/{paymentId}")
    public String editPayment(
            @PathVariable("paymentId") Integer aPaymentId,
            Map<String, Object> map)
    {
        Payment myAccountPayable = paymentService.find(aPaymentId);
        map.put("accountPayable", myAccountPayable);
        return "accountPayable/edit";
    }

    @RequestMapping("save")
    public String savePayment(@ModelAttribute("payment") Payment aPayment)
    {
        LOG.debug("savePayment");

        Payment myPayment = aPayment;

        if (aPayment.getId() != null)
        {
            paymentService.update(aPayment);
        }
        else
        {
            myPayment = paymentService.create(aPayment);
        }

        LOG.debug("redirect account {}", aPayment);
        return "redirect:/accountPayable/" + myPayment.getAccountPayable().getId();
    }

    @RequestMapping("delete/{accountPayableId}")
    public String deleteAccountPayable(@PathVariable("accountPayableId") Integer anAccountPayableId)
    {
        paymentService.delete(anAccountPayableId);
        return "redirect:/accountPayable/1";
    }
}
