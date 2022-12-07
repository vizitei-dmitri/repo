package com.devolution.demo.repository;

import com.devolution.demo.entity.Hotels;
import com.devolution.demo.entity.Product;
import com.devolution.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelsRepository extends JpaRepository<Hotels,Long> {
    List<Hotels> findHotels();
}
