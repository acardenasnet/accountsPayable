/*
 * ---------------------------------------------------------------------------
 *  COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *  All rights reserved.
 *
 *  The Copyright to the computer program(s) herein is the property of
 *  Alejandro Raul Cardenas
 *  The program(s) may be used and/or copied only with the written
 *  permission from Alejandro Cardenas, or in
 *  accordance with the terms and conditions stipulated in the
 *  agreement/contract under which the program(s) have been supplied.
 *  ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.DataserviceCrud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    }

    protected EntityManager getEntityManager()
    {
        return entityManager;
    }

    @Override
    public T create(T t)
    {
        logger.debug("create {}", handles());
        this.entityManager.persist(t);
        this.entityManager.flush();
        this.entityManager.refresh(t);
        logger.debug("End create {}", handles());
        return t;
    }

    @Override
    public T find(K id)
    {
        return entityManager.find(handles(), id);
    }

    @Override
    public void delete(K id)
    {
        T myReference = entityManager.getReference(handles(), id);
        entityManager.remove(myReference);
    }

    @Override
    public T update(T item)
    {
//        if (item instanceof User)
 //       {
//            User user = (User) item;
//            if (user.getId() == 1)
 //           {
 //               return item;
  //          }
 //       }
        return (T) this.entityManager.merge(item);
    }

    @Override
    public List<T> findWithNamedQuery(String aNamedQueryName)
    {
        logger.debug("findWithNamedQuery ({})", aNamedQueryName);
        TypedQuery<T> myQuery = entityManager.createNamedQuery(aNamedQueryName, handles());
        return myQuery.getResultList();
    }

    @Override
    public List<T> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        TypedQuery<T> myQuery = entityManager.createNamedQuery(aNamedQueryName, handles());
        myQuery.setMaxResults(anEnd - aStart);
        myQuery.setFirstResult(aStart);
        return myQuery.getResultList();
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        Query query = entityManager.createNamedQuery(aNamedQueryName);
        Number result = (Number) query.getSingleResult();
        return result.intValue();
    }
}
