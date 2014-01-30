package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.entity.Event;

import java.util.List;

/**
 * Created by acardenas on 1/28/14.
 */
public class EventDataserviceImpl
    extends  DataserviceCrudImpl<Event, Integer>
    implements EventDataservice
{

    @Override
    public Class<Event> handles()
    {
        return Event.class;
    }
}
