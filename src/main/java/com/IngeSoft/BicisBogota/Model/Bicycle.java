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
    Integer Id_bicycle;
    
    @Column(name="brand")
    String Brand;
    @Column(name="year")
    Integer Year;
    @Column(name="price")
    Double Price;
    @Column(nullable=false, name="borrowed")
    Boolean Borrowed;

    //Relations

    // Bicycle 1 -- * Rent 
    @OneToMany(mappedBy = "bicycle")
    List<Rent> rentas = new ArrayList<>();

    // Bicycle 1 -- * Arrive 
    @OneToMany(mappedBy = "bicycle")
    List<Arrive> arrives = new ArrayList<>();

}
