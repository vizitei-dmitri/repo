package com.devolution.demo.repository;

import com.devolution.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("SELECT u from User u where u.age>=10")
    List<User> findUsers();
}