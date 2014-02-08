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
