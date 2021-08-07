package com.trendyol.emailservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class BasketItems {

    @Id
    private long id;

    private String name;

    private Product product;

    private int quantity;

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return product.getPrice() * quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
