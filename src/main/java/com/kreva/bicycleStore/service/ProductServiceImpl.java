package com.kreva.bicycleStore.service;

import com.kreva.bicycleStore.dao.ProductDAO;
import com.kreva.bicycleStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 * implement сервис для запчастей
 * содержит метобы для работа и упровлением товаров
 * */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;


    @Override
    public Product getById(long id) {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> findByChapter(String chapter) {
        return productDAO.findByChapter(chapter);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDAO.findAll();
    }

    public Product newProduct(String name, String comment, String chapter,
                              int prise, int quantity) {
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setComment(comment);
        newProduct.setChapter(chapter);
        newProduct.setPrice(prise);
        newProduct.setQuantity(quantity);
        newProduct.setPicture("none");
        newProduct.setDateAddProduct(new Date());
        System.out.println(newProduct.getDateAddProduct());
        System.out.println(newProduct.getChapter());
        return newProduct;
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    public Product findById(long id) {
        return productDAO.findById(id);
    }

    public void editProdyct(long id, String name, int price, int quantity, String comment, String chapter) {
        Product product = productDAO.findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setComment(comment);
        product.setQuantity(quantity);
        product.setChapter(chapter);
        productDAO.save(product);
    }

    public void remove(long id) {
        productDAO.deleteById(id);
    }
}

