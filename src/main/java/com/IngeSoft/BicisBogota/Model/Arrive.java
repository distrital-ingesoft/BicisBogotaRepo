package com.IngeSoft.BicisBogota.Model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Arrive {

    //Atributes

    @Id
    @GeneratedValue
    Integer idArrive;

    @Column(nullable = false, name="date")
    LocalDate date;

    //Relations

    // Arrive 1 -- * User
    @JsonIgnore
    @ManyToOne
    User user;
    
    // Arrive 1 -- * Bicycle
    @JsonIgnore
    @ManyToOne
    Bicycle bicycle;

    // Arrive 1 -- * Location
    @JsonIgnore
    @ManyToOne
    Location location;
    

}
