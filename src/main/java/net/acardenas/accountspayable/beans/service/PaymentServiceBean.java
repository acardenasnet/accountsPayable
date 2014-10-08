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

package net.acardenas.accountspayable.beans.service;

import net.acardenas.accountspayable.beans.api.PaymentService;
import net.acardenas.accountspayable.beans.impl.PaymentServiceImpl;
import net.acardenas.accountspayable.dataservice.api.PaymentDataservice;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by acardenas on 4/6/14.
 */
@Service
public class PaymentServiceBean
    implements PaymentService
{
    private PaymentService delegate;

    @Autowired
    private PaymentDataservice paymentDataservice;

    @PostConstruct
    void init()
    {
        PaymentServiceImpl myPaymentService = new PaymentServiceImpl();
        myPaymentService.setPaymentDataservice(paymentDataservice);
        delegate = myPaymentService;
    }

    @Override
    public List<Payment> getList(AccountPayable anAccountPayable)
    {
        return delegate.getList(anAccountPayable);
    }

    @Override
    public Payment create(Payment anEntity)
    {
        return delegate.create(anEntity);
    }

    @Override
    public Payment update(Payment anEntity)
    {
        return delegate.update(anEntity);
    }

    @Override
    public List<Payment> getList()
    {
        return delegate.getList();
    }

    @Override
    public List<Payment> readList(int aStart, int anEnd)
    {
        return null;
    }

    @Override
    public Payment find(Integer anId)
    {
        return delegate.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        delegate.delete(anId);
    }

    @Override
    public int countTotalRecord()
    {
        return 0;
    }
}
