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

package net.acardenas.accountspayable.dataservice.service;

import net.acardenas.accountspayable.dataservice.api.PaymentDataservice;
import net.acardenas.accountspayable.dataservice.impl.PaymentDataserviceImpl;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Payment;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by acardenas on 2/10/14.
 */
@Repository
@Transactional
public class PaymentDataserviceRepository
    implements PaymentDataservice
{
    PaymentDataservice delegate;

    @Log
    Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    void init()
    {
        logger.debug("init");
        PaymentDataserviceImpl myPaymentDataservice = new PaymentDataserviceImpl();
        myPaymentDataservice.setEntityManager(entityManager);
        delegate = myPaymentDataservice;
    }

    @Override
    public Class<Payment> handles()
    {
        return delegate.handles();
    }

    @Override
    public Payment create(Payment anEntity)
    {
        return delegate.create(anEntity);
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
    public Payment update(Payment anEntity)
    {
        return delegate.update(anEntity);
    }

    @Override
    public List<Payment> findWithNamedQuery(String aNamedQueryName)
    {
        return delegate.findWithNamedQuery(aNamedQueryName);
    }

    @Override
    public List<Payment> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        return delegate.findWithNamedQuery(aNamedQueryName, aStart, anEnd);
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return delegate.countTotalRecord(aNamedQueryName);
    }

    @Override
    public List<Payment> findByAccountPayable(String aNamedQueryName, AccountPayable anAccountPayable)
    {
        return delegate.findByAccountPayable(aNamedQueryName, anAccountPayable);
    }
}
