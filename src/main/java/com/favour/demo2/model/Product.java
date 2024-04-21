package com.favour.demo2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {
    private int id;
    public String productName;
    public String category;
    public double price;
    public String image;


    public Product() {
    }

    public Product(int id, String productName, String category, double price, String image) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}