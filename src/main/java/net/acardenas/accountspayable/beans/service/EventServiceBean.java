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

import net.acardenas.accountspayable.beans.api.EventService;
import net.acardenas.accountspayable.beans.impl.EventServiceImpl;
import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by acardenas on 2/17/14.
 */
@Service
public class EventServiceBean
    implements EventService
{
    private EventService delegate;

    @Autowired
    private EventDataservice eventDataservice;

    @PostConstruct
    void init()
    {
        EventServiceImpl myEventService = new EventServiceImpl();
        myEventService.setEventDataservice(eventDataservice);
        delegate = myEventService;
    }

    @Override
    public Event create(Event aEvent)
    {
        return delegate.create(aEvent);
    }

    @Override
    public Event update(Event aEvent)
    {
        return delegate.update(aEvent);
    }

    @Override
    public List<Event> getList()
    {
        return delegate.getList();
    }

    @Override
    public List<Event> readList(int aStart, int anEnd)
    {
        return delegate.readList(aStart, anEnd);
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
    public int countTotalRecord()
    {
        return delegate.countTotalRecord();
    }
}
