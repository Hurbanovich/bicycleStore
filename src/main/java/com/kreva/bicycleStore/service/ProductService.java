package com.kreva.bicycleStore.service;

import com.kreva.bicycleStore.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(long id);

    List<Product> findByChapter(String chapter);

    List<Product> getAllProduct();

}
