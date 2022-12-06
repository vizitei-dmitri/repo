package com.devolution.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Set;
@Entity
@Table
@Getter
@Setter
public class Apartaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rooms", nullable = false)
    private BigInteger rooms;

    @Column(name = "seasight")
    private Boolean seasight;

    @Column(name = "is_reservated")
    private Boolean is_reservated;

    @Column(name = "reservation_time")
    private BigInteger reservation_time;

    @ManyToMany(mappedBy = "apartaments")
    private Set<Hotels> hotels;

}
