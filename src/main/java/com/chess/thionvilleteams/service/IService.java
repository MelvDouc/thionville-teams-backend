package com.chess.thionvilleteams.service;

import java.util.List;

public interface IService<T> {
    T getById(long id);

    List<T> getAll();

    T create(T entity);

    T update(T entity, long id);

    void delete(long id);
}
