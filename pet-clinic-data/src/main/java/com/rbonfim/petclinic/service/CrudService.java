package com.rbonfim.petclinic.service;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T obj);

    void delete(T o);

    void deleteById(ID id);
}
