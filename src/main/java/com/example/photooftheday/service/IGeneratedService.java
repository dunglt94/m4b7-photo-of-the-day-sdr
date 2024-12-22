package com.example.photooftheday.service;

import java.util.List;

public interface IGeneratedService<T> {
    List<T> findAll();

    T findById(int id);

    void save(T object);

    void delete(int id);
}
