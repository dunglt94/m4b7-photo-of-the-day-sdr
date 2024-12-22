package com.example.photooftheday.repository;

import java.util.List;

public interface IGeneratedRepository<T> {
    List<T> findAll();

    T findById(int id);

    void save(T object);

    void delete(int id);
}
