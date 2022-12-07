package com.devolution.demo.repository;

import com.devolution.demo.entity.Product;
import com.devolution.demo.entity.Purchase;
import com.devolution.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    List<Product> findProduct();
}
