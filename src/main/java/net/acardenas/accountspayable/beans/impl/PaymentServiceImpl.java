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

package net.acardenas.accountspayable.beans.impl;

import net.acardenas.accountspayable.beans.api.PaymentService;
import net.acardenas.accountspayable.dataservice.api.PaymentDataservice;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Payment;

import java.util.List;

/**
 * Created by acardenas on 4/6/14.
 */
public class PaymentServiceImpl
    implements PaymentService
{
    private PaymentDataservice paymentDataservice;

    public void setPaymentDataservice(PaymentDataservice aPaymentDataservice)
    {
        paymentDataservice = aPaymentDataservice;
    }

    @Override
    public List<Payment> getList(AccountPayable anAccountPayable)
    {
        return null;
    }

    @Override
    public Payment create(Payment anEntity)
    {
        return paymentDataservice.create(anEntity);
    }

    @Override
    public Payment update(Payment anEntity)
    {
        return paymentDataservice.update(anEntity);
    }

    @Override
    public List<Payment> getList()
    {
        return paymentDataservice.findWithNamedQuery(Payment.ALL);
    }

    @Override
    public Payment find(Integer anId)
    {
        return paymentDataservice.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        paymentDataservice.delete(anId);
    }
}
