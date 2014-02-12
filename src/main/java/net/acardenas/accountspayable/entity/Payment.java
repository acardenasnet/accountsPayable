package net.acardenas.accountspayable.entity;

import javax.persistence.*;
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public Date getEffectiveDate()
    {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public AccountPayable getAccountPayable()
    {
        return accountPayable;
    }

    public void setAccountPayable(AccountPayable accountPayable)
    {
        this.accountPayable = accountPayable;
    }
}