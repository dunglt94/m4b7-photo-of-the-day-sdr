package com.example.photooftheday.service;

import java.util.Optional;

public interface IGeneratedService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T object);

    void delete(Long id);

}
