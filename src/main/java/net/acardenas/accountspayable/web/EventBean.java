package net.acardenas.accountspayable.web;

import net.acardenas.accountspayable.beans.api.EventService;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.web.datamodel.LazyEventDataModel;
import org.primefaces.model.LazyDataModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
@ManagedBean
public class EventBean
{
    @Inject
    private EventService eventService;
    private LazyDataModel<Event> lazyDataModel;

    private Event selectedEntity;
    private Event[] selectedEntities;
    private Event newEntity;

    @PostConstruct
    void init()
    {
        selectedEntity = new Event();
        newEntity = new Event();
        lazyDataModel = new LazyEventDataModel(eventService);
    }

    public Event getSelectedEntity()
    {
        return selectedEntity;
    }

    public void setSelectedEntity(Event selectedEntity)
    {
        this.selectedEntity = selectedEntity;
    }

    public Event getNewEntity()
    {
        return newEntity;
    }

    public void setNewEntity(Event newEntity)
    {
        this.newEntity = newEntity;
    }

    public Event[] getSelectedEntities()
    {
        return selectedEntities;
    }

    public void setSelectedEntities(Event[] selectedEntities)
    {
        this.selectedEntities = selectedEntities;
    }

    public LazyDataModel<Event> getLazyDataModel()
    {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Event> lazyDataModel)
    {
        this.lazyDataModel = lazyDataModel;
    }

    public void doCreateEvent()
    {
        eventService.create(newEntity);
    }
}
