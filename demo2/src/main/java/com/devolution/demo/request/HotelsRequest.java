package com.devolution.demo.request;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Purchase;
import lombok.Data;
import java.util.Set;
@Data
public class HotelsRequest {

    private String name;

    private int stars;

    private String country;

    private String city;

    private Set<Purchase> purchases;

    private Set<Apartaments> apartaments;


}
