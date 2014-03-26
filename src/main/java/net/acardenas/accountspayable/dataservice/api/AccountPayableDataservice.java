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

package net.acardenas.accountspayable.dataservice.api;

import net.acardenas.accountspayable.entity.AccountPayable;
import net.acardenas.accountspayable.entity.Event;

import java.util.List;

/**
 * Created by acardenas on 2/7/14.
 */
public interface AccountPayableDataservice
    extends DataserviceCrud<AccountPayable, Integer>
{
    List<AccountPayable> findByEvent(String aNamedQueryName, Event anEvent);
}
