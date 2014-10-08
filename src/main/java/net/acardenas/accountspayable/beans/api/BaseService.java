/*
 * ---------------------------------------------------------------------------
 *    COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
 *    All rights reserved.
 *
 *    The Copyright to the computer program(s) herein is the property of
 *    Alejandro Raul Cardenas
 *    The program(s) may be used and/or copied only with the written
 *    permission from Alejandro Cardenas, or in
 *    accordance with the terms and conditions stipulated in the
 *    agreement/contract under which the program(s) have been supplied.
 *    ---------------------------------------------------------------------------
 */

package net.acardenas.accountspayable.beans.api;

import java.util.List;

/**
 * Created by acardenas on 3/9/14.
 */
public interface BaseService<T, K>
{
    T create(T anEntity);

    T update(T anEntity);

    List<T> getList();

    List<T> readList(int aStart, int anEnd);

    T find(K anId);

    void delete(K anId);

    int countTotalRecord();
}
