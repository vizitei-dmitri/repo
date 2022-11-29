package com.devolution.demo.request;


import com.devolution.demo.response.PurchaseResponse;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {

    private String name;

    private int age;

    private Set<Long> purchaseIds;

}
