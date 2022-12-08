package com.devolution.demo.response;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Purchase;
import lombok.Data;
import java.util.Set;
@Data
public class HotelsResponse {

    private String name;

    private int stars;

    private String country;

    private String city;

    private Set<Apartaments> apartaments;

    private Set<Purchase> purchases;
}
