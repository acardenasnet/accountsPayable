package net.acardenas.accountspayable.dataservice.service;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.dataservice.impl.DataserviceCrudImpl;
import net.acardenas.accountspayable.dataservice.impl.EventDataserviceImpl;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by acardenas on 1/28/14.
 */
@Repository
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