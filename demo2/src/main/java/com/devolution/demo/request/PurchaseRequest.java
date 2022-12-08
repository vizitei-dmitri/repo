package com.devolution.demo.request;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.User;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Set;
@Data
public class PurchaseRequest {

    private String name;

    private Timestamp dateCreated;

    private Timestamp dateUpdated;

//    private Set<Long> productIds;

    private User user;

    private Set<Hotels> hotels;
}
