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
public class Benefits {
    
    //Atributes
    
    @Id
    @GeneratedValue
    @Column(name="id_benefit")
    Integer idBenefit;

    @Column(name="numberOfArrives",nullable=false)
    Integer noOfArrives;

    @Column(name="description",nullable=false)
    String description;
}
