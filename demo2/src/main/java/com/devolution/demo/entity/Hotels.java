package com.devolution.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

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
//    @Check(stars > 0 and stars <= 6)
    private int stars;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "hotels_apartaments",
            joinColumns = @JoinColumn(name = "id_hotels"),
            inverseJoinColumns = @JoinColumn(name = "id_apartaments"))
    private Set<Apartaments> apartaments;
    }
