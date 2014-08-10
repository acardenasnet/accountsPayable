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

package net.acardenas.accountspayable.beans.impl;

import net.acardenas.accountspayable.beans.api.AccountPayableService;
import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;

import java.util.List;

/**
 * Created by acardenas on 3/12/14.
 */
public class AccountPayableServiceImpl
    implements AccountPayableService
{
    private AccountPayableDataservice accountPayableDataservice;

    public void setAccountPayableDataservice(AccountPayableDataservice anAccountPayableDataservice1)
    {
        accountPayableDataservice = anAccountPayableDataservice1;
    }

    @Override
    public AccountPayable create(AccountPayable anEntity)
    {
        return accountPayableDataservice.create(anEntity);
    }

    @Override
    public AccountPayable update(AccountPayable anEntity)
    {
        return accountPayableDataservice.update(anEntity);
    }

    @Override
    public List<AccountPayable> getList()
    {
        return accountPayableDataservice.findWithNamedQuery(AccountPayable.ALL);
    }

    @Override
    public List<AccountPayable> getList(Event anEvent)
    {
        return accountPayableDataservice.findByEvent(AccountPayable.BY_EVENTS, anEvent);
    }

    @Override
    public AccountPayable find(Integer anId)
    {
        return accountPayableDataservice.find(anId);
    }

    @Override
    public void delete(Integer anId)
    {
        accountPayableDataservice.delete(anId);
    }
}
