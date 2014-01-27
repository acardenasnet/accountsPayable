package net.acardenas.accountspayable.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by acardenas on 1/25/14.
 */
@Entity
public class Event
{
    @Id
    private Integer id;
    @OneToMany
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
