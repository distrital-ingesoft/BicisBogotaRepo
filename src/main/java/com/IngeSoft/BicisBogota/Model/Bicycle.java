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
    
    @Id
    @GeneratedValue
    Integer Id_bicycle;
    
    @Column
    String Brand;
    Integer Year;
    Double price;

    // Bicycle 1 -- * Rent 
    @OneToMany(mappedBy = "bicycle")
    List<Rent> rentas = new ArrayList<>();

}
