package com.devolution.demo.request;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PurchaseRequest {

    private String name;

    private Set<Long> productIds;

    private User user;

    private Set<Hotels> hotels;
}
