package com.devolution.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "date_updated")
    private Timestamp dateUpdated;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private double weight;

    @OneToMany(mappedBy = "user")
    private Set<Hotels> hotels;

    @ManyToMany(mappedBy = "products",fetch = FetchType.LAZY,cascade = CascadeType.ALL)//nazvanie polia v purchase
    @JsonBackReference
    private Set<Purchase> purchases;


}
