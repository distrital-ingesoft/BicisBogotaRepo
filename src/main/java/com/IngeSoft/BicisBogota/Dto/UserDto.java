package com.IngeSoft.BicisBogota.Dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class UserDto {
    Long Id_user;
    String Name;
    String Email;
    Long Phone;
    Boolean AdminMode;
    
    public UserDto(Long Id_user, String Name, String Email, Long Phone, Boolean AdminMode){
        this.Id_user=Id_user;
        this.Name=Name;
        this.Email=Email;
        this.Phone=Phone;
        this.AdminMode=AdminMode;
    }
}
