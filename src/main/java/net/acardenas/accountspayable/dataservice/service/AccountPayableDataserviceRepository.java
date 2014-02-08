package net.acardenas.accountspayable.dataservice.service;

import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.dataservice.impl.AccountPayableDataserviceImpl;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.utils.Log;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by acardenas on 2/7/14.
 */
@Repository
@Transactional
public class AccountPayableDataserviceRepository
    implements AccountPayableDataservice
{
    private AccountPayableDataservice delegate;

    @Log
    Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    void init()
    {
        logger.debug("init");
        AccountPayableDataserviceImpl myAccountPayableDataservice = new AccountPayableDataserviceImpl();
        myAccountPayableDataservice.setEntityManager(entityManager);
        delegate = myAccountPayableDataservice;
    }

    @Override
    public Class<AccountPayable> handles()
    {
        return delegate.handles();
    }

    @Override
    public AccountPayable create(AccountPayable anEntity)
    {
        return delegate.create(anEntity);
    }

    @Override
    public AccountPayable find(Integer anId)
    {
        return null;
    }

    @Override
    public void delete(Integer anId)
    {

    }

    @Override
    public AccountPayable update(AccountPayable anEntity)
    {
        return null;
    }

    @Override
    public List<AccountPayable> findWithNamedQuery(String aNamedQueryName)
    {
        return null;
    }

    @Override
    public List<AccountPayable> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd)
    {
        return null;
    }

    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return 0;
    }
}
