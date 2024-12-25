package com.example.photooftheday.service;

import com.example.photooftheday.exception.BadWordsException;

import java.util.Optional;

public interface IGeneratedService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T object) throws BadWordsException;

    void delete(Long id);

}
