package com.devolution.demo.request;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.Purchase;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ProductRequest {

    private String name;

    private double price;

    private double weight;

    private Set<Hotels> hotels;

    private Set<Purchase> purchases;

}
