// ---------------------------------------------------------------------------
// COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2013
// All rights reserved.
//
// The Copyright to the computer program(s) herein is the property of
// Alejandro Raul Cardenas
// The program(s) may be used and/or copied only with the written
// permission from Alejandro Cardenas, or in
// accordance with the terms and conditions stipulated in the
// agreement/contract under which the program(s) have been supplied.
// ---------------------------------------------------------------------------

package net.acardenas.accountspayable.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by acardenas on 1/21/14.
 */
@Entity
public class Payment
    extends BaseEntity
{
    private String name;
    private String description;
    private Double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNTPAYABLE_ID")
    private AccountPayable accountPayable;

    public Payment()
    {
        // empty
    }

    public String getName()
    {
        return name;
    }

    public void setName(String aName)
    {
        name = aName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String aDescription)
    {
        description = aDescription;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double anAmount)
    {
        amount = anAmount;
    }

    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    public void setEffectiveDate(Date anEffectiveDate)
    {
        effectiveDate = anEffectiveDate;
    }

    public AccountPayable getAccountPayable()
    {
        return accountPayable;
    }

    public void setAccountPayable(AccountPayable anAccountPayable)
    {
        accountPayable = anAccountPayable;
    }
}