package com.IngeSoft.BicisBogota.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Bicycle {
    
    //Atributes
    @Id
    //@GeneratedValue
    @Column(unique = true, nullable=false, name="id_bicycle")
    Integer idBicycle;
    
    @Column(name="brand")
    String brand;
    
    @Column(name="year")
    Integer year;
    
    // getPrice
    @Column(name="price")
    Double price;

    // isBorrowed
    @Column(nullable=false, name="borrowed")
    Boolean borrowed;

    //Relations

    // Bicycle 1 -- * Rent 
    @OneToMany(mappedBy = "bicycle")
    List<Rent> rentas = new ArrayList<>();

    // Bicycle 1 -- * Arrive 
    @OneToMany(mappedBy = "bicycle")
    List<Arrive> arrives = new ArrayList<>();

}
