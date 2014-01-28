package net.acardenas.accountspayable.dataservice.api;

/**
 * Created by acardenas on 1/28/14.
 */
public interface DataserviceCrud<T, K>
{
    public T create(T t);

    public T find(K id);

    public void delete(K id);

    public T update(T item);
}
