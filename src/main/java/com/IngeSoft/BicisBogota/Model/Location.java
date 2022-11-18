package com.IngeSoft.BicisBogota.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Location {
    
    // Atributes
    @Id
    @GeneratedValue
    Integer Id_location;

    @Column(nullable = false,name="location_name")
    String Location_name;
    @Column(nullable = false,name="location_address")
    String Location_address;

    //Relations

    //Location 1 -- * Rent
    @OneToMany(mappedBy="location")
    List<Rent> rents = new ArrayList<>();

    //Location 1-- * Arrive
    @OneToMany(mappedBy="location")
    List<Arrive> arrives = new ArrayList<>();

}
