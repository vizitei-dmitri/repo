package com.devolution.demo.response;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ProductResponse {

    private String name;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private double price;

    private double weight;

}
