package com.devolution.demo.response;
import lombok.Data;
import java.util.Set;

@Data
public class UserResponse {

    private String name;

    private int age;

    private Set<PurchaseResponse> purchaseSet;
}
