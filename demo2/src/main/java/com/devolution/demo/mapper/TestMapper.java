package com.devolution.demo.mapper;

import com.devolution.demo.entity.Product;
import com.devolution.demo.entity.Purchase;
import com.devolution.demo.entity.User;
import com.devolution.demo.response.ProductResponse;
import com.devolution.demo.response.PurchaseResponse;
import com.devolution.demo.response.UserResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TestMapper {

    public UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setAge(user.getAge());
        userResponse.setName(user.getName());
        if (user.getPurchaseSet() != null && !user.getPurchaseSet().isEmpty())
            userResponse.setPurchaseSet(user.getPurchaseSet().stream().map(this::map).collect(Collectors.toSet()));
        return userResponse;
    }

    public PurchaseResponse map(Purchase purchase) {
        PurchaseResponse purchaseResponse = new PurchaseResponse();
        purchaseResponse.setName(purchase.getName());
        purchaseResponse.setDateCreated(map(purchase.getDateCreated()));
        purchaseResponse.setDateUpdated(map(purchase.getDateUpdated()));
        if (purchase.getProducts() != null && !purchase.getProducts().isEmpty())
            purchaseResponse.setProducts(purchase.getProducts().stream().map(this::map).collect(Collectors.toSet()));
        return purchaseResponse;
    }

    public ProductResponse map(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setDateCreated(map(product.getDateCreated()));
        productResponse.setDateUpdated(map(product.getDateUpdated()));
        productResponse.setWeight(product.getWeight());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public LocalDateTime map(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }
}
