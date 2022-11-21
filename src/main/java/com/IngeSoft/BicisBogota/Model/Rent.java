package com.IngeSoft.BicisBogota.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Rent {
    
    //Atributes

    @Id
    @GeneratedValue
    @Column(name="id_rent")
    Integer idRent;

    // Relations

    //Rent * -- 1 User
    @ManyToOne
    User user;

    //Rent * -- 1 Bicycle
    @ManyToOne
    Bicycle bicycle;

    //Rent * -- 1 Location
    @ManyToOne
    Location location;

}
