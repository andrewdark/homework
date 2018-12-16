package ua.pp.darknsoft.dao;

import java.io.Serializable;
import java.util.*;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {
    protected final Class<T> entityClass;
    private Map<ID, T> db = new HashMap<>();

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;

    }

    public T findById(ID id) {
        return db.get(id);
    }

    public List<T> findAll() {
        List<T> list;
        Collection<T> coll = db.values();
        if (coll instanceof List)
            list = (List) coll;
        else
            list = new ArrayList(coll);
        return list;
    }

    public Long getCount() {

        return Long.valueOf(db.size());
    }

    public T saveOrUpdate(ID id, T instance) {
        return db.put(id, instance);
    }

    public void delete(ID id) {
        db.remove(id);
    }

    public Map<ID, T> getDb() {
        return db;
    }
}
