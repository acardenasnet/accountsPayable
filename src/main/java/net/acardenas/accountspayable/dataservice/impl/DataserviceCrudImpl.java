package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.DataserviceCrud;
import net.acardenas.accountspayable.entity.Event;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by acardenas on 1/28/14.
 */
public abstract class DataserviceCrudImpl<T, K>
    implements DataserviceCrud<T, K>
{
    private EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(DataserviceCrud.class);

    public DataserviceCrudImpl()
    {
        // empty
    }

    public void setEntityManager(EntityManager aEntityManager)
    {
        entityManager = aEntityManager;
        logger.debug("{}", aEntityManager);
        logger.debug("{}", entityManager);
    }

    public EntityManager getEntityManager()
    {
        logger.debug("get EntityManager {}", entityManager);
        return entityManager;
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
        TypedQuery<T> myQuery = entityManager.createNamedQuery(aNamedQueryName, handles());
        return myQuery.getResultList();
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
