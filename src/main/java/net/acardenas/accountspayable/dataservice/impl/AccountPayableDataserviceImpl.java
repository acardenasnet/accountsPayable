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

/**
 * Created by acardenas on 2/7/14.
 */
public class AccountPayableDataserviceImpl
    extends DataserviceCrudImpl<AccountPayable, Integer>
    implements AccountPayableDataservice
{

    @Override
    public Class<AccountPayable> handles()
    {
        return AccountPayable.class;
    }
}
