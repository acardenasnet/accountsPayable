package net.acardenas.accountspayable.dataservice.impl;

import net.acardenas.accountspayable.dataservice.api.PaymentDataservice;
import net.acardenas.accountspayable.entity.Payment;

/**
 * Created by acardenas on 2/9/14.
 */
public class PaymentDataserviceImpl
    extends DataserviceCrudImpl<Payment, Integer>
    implements PaymentDataservice
{
    @Override
    public Class<Payment> handles()
    {
        return Payment.class;
    }
}
