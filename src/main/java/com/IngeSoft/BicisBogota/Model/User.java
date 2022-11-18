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
    
    // atributes

    @Id
    @Column(unique=true, nullable = false, name="id_user")
    Long Id_user;

    @Column(nullable=false,name="name")
    String Name;

    @Column(unique = true, name="email")
    String Email;

    @Column(unique = true, name="phone")
    String Phone;

    @Column(name="adminmode")
    Boolean AdminMode;

    // relations

    // User 1 -- * Rent
    @OneToMany(mappedBy = "user")
    List<Rent> rents = new ArrayList<>(); 

    // User 1 -- * Arrive
    @OneToMany(mappedBy = "user")
    List<Arrive> arrives = new ArrayList<>();
    

}
