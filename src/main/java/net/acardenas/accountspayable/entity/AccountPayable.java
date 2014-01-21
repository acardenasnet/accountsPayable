package net.acardenas.accountspayable.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by acardenas on 1/20/14.
 */
@Entity
public class AccountPayable
{
    @Id
    private Integer id;
    private String name;
    private Double total;
    @OneToMany(mappedBy = "accountPayable", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Payment> payments;

    public AccountPayable()
    {

    }
}
