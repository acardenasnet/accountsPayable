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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Created by acardenas on 1/25/14.
 */
@Entity
@NamedQueries
        ({
                @NamedQuery(name = Event.ALL, query = "SELECT e FROM Event e"),
                @NamedQuery(name = Event.TOTAL, query = "SELECT COUNT(e) FROM Event e")
        })
public class Event
    extends BaseEntity
{

	private static final long serialVersionUID = -5848441646825081339L;
	public static final String ALL = "Event.allEvents";
    public static final String TOTAL = "Event.countEventsTotal";

    private String name;
    @OneToMany( mappedBy = "event")
    private List<AccountPayable> accountsPayable;

    public String getName()
    {
        return name;
    }

    public void setName(String aName)
    {
        name = aName;
    }

    public List<AccountPayable> getAccountsPayable()
    {
        if (accountsPayable == null)
        {
            accountsPayable = new ArrayList<AccountPayable>();
        }
        return accountsPayable;
    }

    public void setAccountsPayable(List<AccountPayable> anAccountsPayable)
    {
        accountsPayable = anAccountsPayable;
    }

    @Override
    public String toString()
    {
        StringBuilder myStringBuilder = new StringBuilder();
        myStringBuilder.append("[")
                .append("Id = ").append(getId())
                .append("Name = ").append(getName())
                .append("]");
        return myStringBuilder.toString();
    }
}