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

import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.dataservice.impl.AccountPayableDataserviceImpl;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by acardenas on 2/7/14.
 */
@Repository
@Transactional
public class AccountPayableDataserviceRepository
    implements AccountPayableDataservice
{
    private AccountPayableDataservice delegate;

    @Log
    Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    void init()
    {
        logger.debug("init");
        AccountPayableDataserviceImpl myAccountPayableDataservice = new AccountPayableDataserviceImpl();
        myAccountPayableDataservice.setEntityManager(entityManager);
        delegate = myAccountPayableDataservice;
    }

    @Override
    public Class<AccountPayable> handles()
    {
        return delegate.handles();
    }

    @Override
    public AccountPayable create(AccountPayable anEntity)
    {
        logger.debug("create account {}", anEntity);
        return delegate.create(anEntity);
    }

    @Override
    public AccountPayable find(Integer anId)
    {
        return delegate.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        delegate.delete(anId);
    }

    @Override
    public AccountPayable update(AccountPayable anEntity)
    {
        return delegate.update(anEntity);
    }

    @Override
    public List<AccountPayable> findWithNamedQuery(String aNamedQueryName)
    {
        logger.debug("{}", delegate.findWithNamedQuery(aNamedQueryName));
        return delegate.findWithNamedQuery(aNamedQueryName);
    }

    @Override
    public List<AccountPayable> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        return delegate.findWithNamedQuery(aNamedQueryName, aStart, anEnd);
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return 0;
    }

    @Override
    public List<AccountPayable> findByEvent(String aNamedQueryName, Event anEvent)
    {
        return delegate.findByEvent(aNamedQueryName, anEvent);
    }
}
