package com.devolution.demo.repository;

import com.devolution.demo.entity.Apartaments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentsRepository extends JpaRepository<Apartaments,Long> {

}
