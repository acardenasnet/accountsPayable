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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by acardenas on 2/9/14.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer anId)
    {
        id = anId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof BaseEntity))
        {
            return false;
        }
        else if (((BaseEntity) obj).id.equals(this.id))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String toString()
    {
        return "entity." + this.getClass() + "[ id=" + id + " ] ";
    }
}
