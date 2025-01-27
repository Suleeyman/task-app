package model;

import java.util.ArrayList;

public interface IRepository<T extends IEntity> {
    T create(T entity);

    T getById(int id);

    ArrayList<T> getAll();

    boolean deleteById(int id);

    T updateById(int id, T entity);
}
