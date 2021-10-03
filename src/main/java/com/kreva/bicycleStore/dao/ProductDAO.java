package com.kreva.bicycleStore.dao;

import com.kreva.bicycleStore.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDAO extends CrudRepository<Product, Long> {
    Product findById(long id);

    List<Product> findByChapter(String chapter);

    List<Product> findAll();
}
