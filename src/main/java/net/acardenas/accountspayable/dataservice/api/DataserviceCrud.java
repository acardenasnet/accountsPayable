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

package net.acardenas.accountspayable.dataservice.api;

import java.util.List;

/**
 * Created by acardenas on 1/28/14.
 */
public interface DataserviceCrud<T, K>
{
    /**
     * Returns the type that is handled by this handler. This type is equal to
     * the type as specified in the generic part of this class. This method is
     * required runtime because the generic information is not available
     * anymore at that time.
     *
     * @return the handled type.
     */
    Class<T> handles();

    /**
     * Stores an instance of the entity class in the database
     *
     * @param anEntity Object
     * @return
     */
    T create(T anEntity);

    /**
     * Retrieves an entity instance that was previously persisted to the
     * database
     *
     * @param anId
     * @return
     */
    T find(K anId);

    /**
     * Removes the record that is associated with the entity instance
     *
     * @param anId
     */
    void delete(K anId);

    /**
     * Updates the entity instance
     *
     * @param anEntity
     * @return the object that is updated
     */
    T update(T anEntity);

    /**
     * Returns the number of records that meet the criteria
     * @param aNamedQueryName
     * @return List
     */
    List<T> findWithNamedQuery(String aNamedQueryName);

    /**
     * Returns the number of records that will be used with lazy loading / pagination
     * @param aNamedQueryName
     * @param aStart
     * @param anEnd
     * @return List
     */
    List<T> findWithNamedQuery(String aNamedQueryName, int aStart, int anEnd);

    /**
     * Returns the number of total records
     * @param aNamedQueryName
     * @return int
     */
    int countTotalRecord(String aNamedQueryName);
}
