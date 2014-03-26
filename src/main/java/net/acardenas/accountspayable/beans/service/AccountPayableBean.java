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
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by acardenas on 3/26/14.
 */
@Service
public class AccountPayableBean
    implements AccountPayableService
{

    @Override
    public List<AccountPayable> getList(Event anEvent)
    {
        return null;
    }

    @Override
    public AccountPayable create(AccountPayable anEntity)
    {
        return null;
    }

    @Override
    public AccountPayable update(AccountPayable anEntity)
    {
        return null;
    }

    @Override
    public List<AccountPayable> getList()
    {
        return null;
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
}
