package dao.api;

import java.util.List;

/**
 * Created by Tretiak Anton on 08.11.2016.
 */
public interface GenericDAO<T> {
    List<T> getAll();
    void add(T entity);
    void remove(T entity);
}
