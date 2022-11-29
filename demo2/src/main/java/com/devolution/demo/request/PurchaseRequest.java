package com.devolution.demo.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class PurchaseRequest {

    private String name;

    private Set<Long> productIds;
}
