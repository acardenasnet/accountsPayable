package net.acardenas.accountspayable.dataservice.service;

import net.acardenas.accountspayable.dataservice.api.EventDataservice;
import net.acardenas.accountspayable.dataservice.impl.DataserviceCrudImpl;
import net.acardenas.accountspayable.entity.Event;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by acardenas on 1/28/14.
 */
@Repository
public class EventDataserviceRepository
    extends DataserviceCrudImpl<Event, Integer>
    implements EventDataservice
{
    @PostConstruct
    void init()
    {

    }
}
