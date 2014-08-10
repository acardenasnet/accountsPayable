/*
 * ---------------------------------------------------------------------------
 *    COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *    All rights reserved.
 *
 *    The Copyright to the computer program(s) herein is the property of
 *    Alejandro Raul Cardenas
 *    The program(s) may be used and/or copied only with the written
 *    permission from Alejandro Cardenas, or in
 *    accordance with the terms and conditions stipulated in the
 *    agreement/contract under which the program(s) have been supplied.
 *    ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.beans.service;

import net.acardenas.accountspayable.beans.api.AccountPayableService;
import net.acardenas.accountspayable.beans.impl.AccountPayableServiceImpl;
import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by acardenas on 3/26/14.
 */
@Service
public class AccountPayableBean
    implements AccountPayableService
{
    private AccountPayableService delegate;

    @Autowired
    private AccountPayableDataservice accountPayableDataservice;

    @PostConstruct
    void init()
    {
        AccountPayableServiceImpl myAccountPayableService = new AccountPayableServiceImpl();
        myAccountPayableService.setAccountPayableDataservice(accountPayableDataservice);
        delegate = myAccountPayableService;
    }

    @Override
    public List<AccountPayable> getList(Event anEvent)
    {
        return delegate.getList(anEvent);
    }

    @Override
    public AccountPayable create(AccountPayable anEntity)
    {
        return delegate.create(anEntity);
    }

    @Override
    public AccountPayable update(AccountPayable anEntity)
    {
        return delegate.update(anEntity);
    }

    @Override
    public List<AccountPayable> getList()
    {
        return delegate.getList();
    }

    @Override
    public AccountPayable find(Integer anId)
    {
        return delegate.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        delegate.delete(anId);
    }
}
