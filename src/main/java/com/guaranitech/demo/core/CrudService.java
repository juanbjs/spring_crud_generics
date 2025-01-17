package com.guaranitech.demo.core;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    List<T> findAllById(Iterable<ID> ids);

    T update(T entity);

    Iterable<T> update(Iterable<T> entities);

    T save(T entity);

    Iterable<T> save(Iterable<T> entities);

    void deleteById(ID id);

    void delete(T entity);

    void deleteAllById(Iterable<? extends ID> ids);
}
