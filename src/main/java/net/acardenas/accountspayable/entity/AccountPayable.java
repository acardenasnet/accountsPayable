package net.acardenas.accountspayable.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by acardenas on 1/20/14.
 */
@Entity
public class AccountPayable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double total;
    @OneToMany(mappedBy = "accountPayable", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Payment> payments;

    public AccountPayable()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
