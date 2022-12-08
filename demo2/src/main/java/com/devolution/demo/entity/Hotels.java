package com.devolution.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stars")
    private int stars;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @ManyToMany(mappedBy = "hotels",fetch = FetchType.LAZY,cascade = CascadeType.ALL)//nazvanie polia v purchase
    @JsonBackReference
    private Set<Purchase> purchases;

    @ManyToMany
    @JoinTable(
            name = "hotels_apartaments",
            joinColumns = @JoinColumn(name = "id_hotels"),
            inverseJoinColumns = @JoinColumn(name = "id_apartaments"))
    private Set<Apartaments> apartaments;
    }
