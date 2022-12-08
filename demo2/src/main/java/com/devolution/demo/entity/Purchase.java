package com.devolution.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "date_updated")
    private Timestamp dateUpdated;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="iduser")//priviazivaet po colonke v sql
    @JsonBackReference
    private User user;


    @ManyToMany
    @JoinTable(
            name = "purchase_hotels",//nazvanie tretiei tablitzi
            joinColumns = @JoinColumn(name = "idpur"),// svaizi s purchase
            inverseJoinColumns = @JoinColumn(name = "idhot"))// sviazi s product
    @JsonManagedReference
    private Set<Hotels> hotels;

}
