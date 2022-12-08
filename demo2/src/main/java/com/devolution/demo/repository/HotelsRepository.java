package com.devolution.demo.repository;

import com.devolution.demo.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository<Hotels,Long> {

}
