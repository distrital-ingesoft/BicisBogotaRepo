package com.IngeSoft.BicisBogota.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

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
public class User {
    
    // atributos

    @Id
    @Column(name="id_user")
    Long Id_user;

    @Column(nullable=false)
    String Name;

    @Column(unique = true)
    String Email;

    String Phone;

    Boolean AdminMode;

    // relaciones

    // 1 usuario tiene muchas rentas
    // tiene que ser una colección
    // list, set, ..
    @OneToMany(mappedBy = "user")
    List<Rent> rentas = new ArrayList<>(); 

}
