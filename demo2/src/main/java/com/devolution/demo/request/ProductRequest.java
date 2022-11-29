package com.devolution.demo.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductRequest {

    private String name;

    private double price;

    private double weight;

}
