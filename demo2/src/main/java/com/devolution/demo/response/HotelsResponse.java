package com.devolution.demo.response;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Product;
import com.devolution.demo.entity.User;
import lombok.Data;

import java.util.Set;
@Data
public class HotelsResponse {

    private String name;

    private int stars;

    private String country;

    private String city;

    private Product product;

    private Set<Apartaments> apartaments;
}
