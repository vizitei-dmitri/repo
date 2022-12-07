package com.devolution.demo.request;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.Product;
import lombok.Data;

import java.util.Set;

@Data
public class HotelsRequest {

    private String name;

    private int stars;

    private String country;

    private String city;

    private Product product;

    private Set<Apartaments> apartaments;


}
