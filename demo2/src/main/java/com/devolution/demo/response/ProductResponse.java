package com.devolution.demo.response;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.Purchase;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ProductResponse {

    private String name;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private double price;

    private double weight;

    private Set<Hotels> hotels;

    private Set<Purchase> purchases;
}
