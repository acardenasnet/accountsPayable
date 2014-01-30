package net.acardenas.accountspayable.entity;

import org.eclipse.persistence.internal.oxm.schema.model.All;

import javax.persistence.*;
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
{
    public final static String ALL = "Event.populateUsers";
    public final static String TOTAL = "Event.countUsersTotal";

    @Id
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountPayable> accountPayables;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public List<AccountPayable> getAccountPayables()
    {
        return accountPayables;
    }

    public void setAccountPayables(List<AccountPayable> accountPayables)
    {
        this.accountPayables = accountPayables;
    }
}
