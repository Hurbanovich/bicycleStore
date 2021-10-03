package com.kreva.bicycleStore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "krevastore", name = "krevaproduct")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String chapter;
    private int price;
    private String comment;
    private String picture;
    private int quantity;
    private Date date_add_product;

    public Product() {
    }

    public Product(long id, String name,
                   String chapter, int price,
                   String comment, String picture,
                   int quantity, Date dateAddProduct) {
        this.id = id;
        this.name = name;
        this.chapter = chapter;
        this.price = price;
        this.comment = comment;
        this.picture = picture;
        this.quantity = quantity;
        this.date_add_product = dateAddProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateAddProduct() {
        return date_add_product;
    }

    public void setDateAddProduct(Date dateAddProduct) {
        this.date_add_product = dateAddProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chapter=" + chapter +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", picture='" + picture + '\'' +
                ", quantity=" + quantity +
                ", dateAddProduct=" + date_add_product +
                '}';
    }
}
