package com.devolution.demo.repository;

import com.devolution.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentsRepository extends JpaRepository<Product,Long> {
}