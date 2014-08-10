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

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.dataservice.impl.EventDataserviceImpl;
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
 * Created by acardenas on 1/28/14.
 */
@Repository
@Transactional
public class EventDataserviceRepository
    implements EventDataservice
{
    private EventDataservice delegate;

    @Log
    Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    void init()
    {
        logger.debug("init");
        EventDataserviceImpl myEventDataservice = new EventDataserviceImpl();
        myEventDataservice.setEntityManager(entityManager);
        delegate = myEventDataservice;
    }

    @Override
    public Class<Event> handles()
    {
        return delegate.handles();
    }

    @Override
    public Event create(Event anEntity)
    {
        return delegate.create(anEntity);
    }

    @Override
    public Event find(Integer anId)
    {
        return delegate.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        delegate.delete(anId);
    }

    @Override
    public Event update(Event anEntity)
    {
        return delegate.update(anEntity);
    }

    @Override
    public List<Event> findWithNamedQuery(String aNamedQueryName)
    {
        return delegate.findWithNamedQuery(aNamedQueryName);
    }

    @Override
    public List<Event> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        return delegate.findWithNamedQuery(aNamedQueryName, aStart, anEnd);
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return delegate.countTotalRecord(aNamedQueryName);
    }
}