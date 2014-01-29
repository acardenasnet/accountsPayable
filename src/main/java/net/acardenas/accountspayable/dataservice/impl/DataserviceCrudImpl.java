package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.DataserviceCrud;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by acardenas on 1/28/14.
 */
public abstract class DataserviceCrudImpl<T, K>
    implements DataserviceCrud<T, K>
{
    private EntityManager entityManager;

    @Log
    Logger logger;

    public DataserviceCrudImpl()
    {
        // empty
    }

    public void setEntityManager(EntityManager aEntityManager)
    {
        entityManager = aEntityManager;
    }

    @Override
    public T create(T t)
    {
        this.entityManager.persist(t);
        this.entityManager.flush();
        this.entityManager.refresh(t);
        return t;
    }

    @Override
    public T find(K id)
    {
        return null;
    }

    @Override
    public void delete(K id)
    {

    }

    @Override
    public T update(T item)
    {
        return null;
    }

    @Override
    public List<T> findWithNamedQuery(String aNamedQueryName)
    {
        logger.debug("findWithNamedQuery");
        logger.debug("{}", entityManager);
        return entityManager.createNamedQuery(aNamedQueryName,handles()).getResultList();
    }

    @Override
    public List<T> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        return null;
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return 0;
    }
}
