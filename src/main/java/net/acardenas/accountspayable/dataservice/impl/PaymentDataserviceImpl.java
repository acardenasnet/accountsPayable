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
