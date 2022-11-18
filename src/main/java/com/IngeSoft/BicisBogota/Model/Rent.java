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
public class Rent {
    
    @Id
    @GeneratedValue
    @Column(name="id_rent")
    Integer Id_rent;

    @Column
    String Location_name;

    // relaciones
    // no son atributos


    // Long Id_user;
    // 1 renta tiene 1 usuario
    // renta * --- 1 usuario
    @ManyToOne
    User user;

    // Integer Id_bicycle;
    // cada renta tiene 1 bicicleta
    // renta * -- 1 bicycle
    @ManyToOne
    Bicycle bicycle;

}
