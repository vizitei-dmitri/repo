package com.devolution.demo.repository;

import com.devolution.demo.entity.Apartaments;
import com.devolution.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartamentsRepository extends JpaRepository<Apartaments,Long> {
    List<Apartaments> getApartaments();
}
