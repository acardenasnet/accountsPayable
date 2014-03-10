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

package net.acardenas.accountspayable.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by acardenas on 1/20/14.
 */
@Entity
@NamedQueries
        ({
                @NamedQuery(name = AccountPayable.ALL, query = "SELECT a FROM AccountPayable a"),
                @NamedQuery(name = AccountPayable.BY_EVENTS, query = "SELECT a FROM AccountPayable a WHERE a.event = :event"),
                @NamedQuery(name = AccountPayable.TOTAL, query = "SELECT COUNT(a) FROM AccountPayable a")
        })
public class AccountPayable
    extends BaseEntity
{

	private static final long serialVersionUID = 1L;
	/** Query name to retrieve all the accounts Payable */
    public static final String ALL = "AccountPayable.populatedAccountsPayable";
    public static final String BY_EVENTS = "AccountPayable.byEvent";
    public static final String TOTAL = "AccountPayable.countAccountsPayableTotal";

    private String name;
    private Double total;
    @OneToMany(mappedBy = "accountPayable")
    private List<Payment> payments;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    public AccountPayable()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String aName)
    {
        name = aName;
    }

    public Double getTotal()
    {
        return total;
    }

    public void setTotal(Double aTotal)
    {
        total = aTotal;
    }

    public List<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payment> aPayments)
    {
        payments = aPayments;
    }

	public Event getEvent() 
	{
		return event;
	}

	public void setEvent(Event anEvent) 
	{
		event = anEvent;
	}
}
