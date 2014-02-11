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
                @NamedQuery(name = AccountPayable.TOTAL, query = "SELECT COUNT(a) FROM AccountPayable a")
        })
public class AccountPayable
    extends BaseEntity
{
    public final static String ALL = "AccountPayable.populateUsers";
    public final static String TOTAL = "AccountPayable.countUsersTotal";

    private String name;
    private Double total;
    @OneToMany(mappedBy = "accountPayable")
    private List<Payment> payments;

    public AccountPayable()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getTotal()
    {
        return total;
    }

    public void setTotal(Double total)
    {
        this.total = total;
    }

    public List<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payment> payments)
    {
        this.payments = payments;
    }

}
