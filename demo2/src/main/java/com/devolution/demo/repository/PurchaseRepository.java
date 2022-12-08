package com.devolution.demo.repository;

import com.devolution.demo.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Hotels,Long> {

}
