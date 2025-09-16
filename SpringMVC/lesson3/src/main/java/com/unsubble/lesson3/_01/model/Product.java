package com.unsubble.lesson3._01.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productId;
    private String name;
    private double price;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private String condition;

}
