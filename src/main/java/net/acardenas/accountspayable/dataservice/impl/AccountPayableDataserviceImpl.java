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

import net.acardenas.accountspayable.dataservice.api.AccountPayableDataservice;
import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by acardenas on 2/7/14.
 */
public class AccountPayableDataserviceImpl
    extends DataserviceCrudImpl<AccountPayable, Integer>
    implements AccountPayableDataservice
{

    private Logger logger = LoggerFactory.getLogger(AccountPayableDataserviceImpl.class);

    @Override
    public Class<AccountPayable> handles()
    {
        return AccountPayable.class;
    }

    @Override
    public List<AccountPayable> findByEvent(String aNamedQueryName, Event anEvent)
    {
        logger.debug("findByEvent ({})", aNamedQueryName);
        TypedQuery<AccountPayable> myQuery = getEntityManager().createNamedQuery(aNamedQueryName, handles());
        myQuery.setParameter(AccountPayable.EVENT_PARAMETER, anEvent);
        return myQuery.getResultList();
    }
}
