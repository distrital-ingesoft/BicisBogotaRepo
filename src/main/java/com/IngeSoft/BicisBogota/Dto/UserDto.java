package com.IngeSoft.BicisBogota.Dto;

import com.IngeSoft.BicisBogota.Model.User;

//import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {
    String name;
    String email;

    public UserDto (User user) {
        this(user.getName(), user.getEmail());
    }

    public UserDto (String name, String email) {
        this.name = name;
        this.email = email;
    }
}
