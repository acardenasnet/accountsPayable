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

/**
 * Created by acardenas on 1/28/14.
 */
@Repository
public class EventDataserviceRepository
    extends DataserviceCrudImpl<Event, Integer>
    implements EventDataservice
{
    private EventDataservice delegate;

    @Log
    Logger logger;

    @Autowired
    private EntityManager entityManager;

    @PostConstruct
    void init()
    {
        logger.debug("init");
        EventDataserviceImpl myEventDataservice = new EventDataserviceImpl();
        logger.debug("{}", entityManager);
        myEventDataservice.setEntityManager(entityManager);
        delegate = myEventDataservice;
    }

    @Override
    public Class<Event> handles()
    {
        return delegate.handles();
    }
}
