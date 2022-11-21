package com.IngeSoft.BicisBogota.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    Integer idLocation;

    @Column(nullable = false,name="location_name")
    String locationName;
    @Column(nullable = false,name="location_address")
    String locationAddress;

    //Relations

    //Location 1 -- * Rent
    @JsonIgnore
    @OneToMany(mappedBy="location")
    List<Rent> rents = new ArrayList<>();

    //Location 1-- * Arrive
    @JsonIgnore
    @OneToMany(mappedBy="location")
    List<Arrive> arrives = new ArrayList<>();

}
