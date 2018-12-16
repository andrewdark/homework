package ua.pp.darknsoft.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    T findById(ID id);
    List<T> findAll();
    Long getCount();
    T saveOrUpdate(ID id,T entity);
    void delete(ID id);
}
