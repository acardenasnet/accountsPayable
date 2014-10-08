package net.acardenas.accountspayable.web.datamodel;

import net.acardenas.accountspayable.beans.api.EventService;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.utils.LazySorter;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LazyEventDataModel
        extends LazyDataModel<Event>
        implements Serializable
{
    private Logger LOG = LoggerFactory.getLogger(LazyEventDataModel.class);
    // Data Source for binding data to the DataTable
    private List<Event> datasource;
    // Selected Page size in the DataTable
    private int pageSize;
    // Current row index number
    private int rowIndex;
    // Total row number
    private int rowCount;
    // Data Access Service for create read update delete operations
    private EventService crudService;

    public LazyEventDataModel(EventService aEventService)
    {
        crudService = aEventService;
    }

    /**
     * Lazy loading user list with sorting ability
     * @param first
     * @param pageSize
     * @param sortField
     * @param sortOrder
     * @param filters
     * @return List<User>
     */
    @Override
    public List<Event> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters)
    {
        datasource = crudService.readList(first, first + pageSize);
        LOG.debug("Datasource result {}", datasource);
        // if sort field is not null then we sort the field according to sortfield and sortOrder parameter
        if(sortField != null)
        {
            Collections.sort(datasource, new LazySorter(sortField, sortOrder));
        }
        setRowCount(crudService.countTotalRecord());
        return datasource;
    }

    /**
     * Gets the user object's primary key
     * @param anEvent
     * @return Object
     */
    @Override
    public Object getRowKey(Event anEvent)
    {
        return anEvent.getId().toString();
    }

}
