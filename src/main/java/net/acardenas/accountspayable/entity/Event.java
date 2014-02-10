package net.acardenas.accountspayable.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
    public final static String ALL = "Event.populateUsers";
    public final static String TOTAL = "Event.countUsersTotal";

    private String name;
    @OneToMany
    @JoinColumn(name = "EVENT_ID")
    private List<AccountPayable> accountPayables;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<AccountPayable> getAccountPayables()
    {
        if (accountPayables == null)
        {
            accountPayables = new ArrayList<AccountPayable>();
        }
        return accountPayables;
    }

    public void setAccountPayables(List<AccountPayable> accountPayables)
    {
        this.accountPayables = accountPayables;
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