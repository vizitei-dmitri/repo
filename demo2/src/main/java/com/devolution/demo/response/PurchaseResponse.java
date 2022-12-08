package com.devolution.demo.response;

import com.devolution.demo.entity.User;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class PurchaseResponse {

    private String name;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private User user;

    private Set<HotelsResponse> hotels;
//    private Set<ProductResponse> products;
}
