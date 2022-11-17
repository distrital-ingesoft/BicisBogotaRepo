package com.IngeSoft.BicisBogota.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    
    @Id
    Long Id_user;

    @Column(nullable=false)
    String Name;
    String Email;
    Long Phone;
    Boolean AdminMode;

}
