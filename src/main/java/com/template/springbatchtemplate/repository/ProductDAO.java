package com.template.springbatchtemplate.repository;

import com.template.springbatchtemplate.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO<T> {

    Optional<T> findById(int id);

    List<T> findAll();

    List<T> findBelowThreshold();

    void save(T t);

    void update(T t);

    void delete(T t);
}
