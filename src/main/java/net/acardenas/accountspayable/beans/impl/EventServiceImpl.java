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

import net.acardenas.accountspayable.beans.api.EventService;
import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.entity.Event;

import java.util.List;

/**
 * Created by acardenas on 2/17/14.
 */
public class EventServiceImpl
    implements EventService
{
    private EventDataservice eventDataservice;

    public void setEventDataservice(EventDataservice anEventDataservice)
    {
        eventDataservice = anEventDataservice;
    }

    @Override
    public Event create(Event aEvent)
    {
        return eventDataservice.create(aEvent);
    }

    @Override
    public Event update(Event aEvent)
    {
        return eventDataservice.update(aEvent);
    }

    @Override
    public List<Event> getList()
    {
        return eventDataservice.findWithNamedQuery(Event.ALL);
    }

    @Override
    public List<Event> readList(int aStart, int anEnd)
    {
        return eventDataservice.findWithNamedQuery(Event.ALL, aStart, anEnd);
    }

    @Override
    public Event find(Integer anId)
    {
        return eventDataservice.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        eventDataservice.delete(anId);
    }

    @Override
    public int countTotalRecord()
    {
        return eventDataservice.countTotalRecord(Event.TOTAL);
    }
}
