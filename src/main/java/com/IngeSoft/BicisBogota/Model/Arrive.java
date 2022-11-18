package com.IngeSoft.BicisBogota.Model;


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
    Integer Id_arrive;

    //Relations

    // Arrive 1 -- * User
    @ManyToOne
    User user;
    
    // Arrive 1 -- * Bicycle
    @ManyToOne
    Bicycle bicycle;

    // Arrive 1 -- * Location
    @ManyToOne
    Location location;
    

}
