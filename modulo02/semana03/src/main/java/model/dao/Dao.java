package model.dao;

public interface Dao<T> {
    void save(T t);

    void update(T t);

    T find(long id);

    void delete(T t);
}
