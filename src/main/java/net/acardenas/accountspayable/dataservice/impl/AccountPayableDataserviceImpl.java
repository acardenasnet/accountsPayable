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
