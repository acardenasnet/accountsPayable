package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.DataserviceCrud;

import javax.persistence.EntityManager;

/**
 * Created by acardenas on 1/28/14.
 */
public class DataserviceCrudImpl<T, K>
    implements DataserviceCrud<T, K>
{
    private EntityManager entityManager;

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
}
