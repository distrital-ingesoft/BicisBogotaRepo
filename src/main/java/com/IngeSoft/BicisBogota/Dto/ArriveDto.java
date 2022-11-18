package com.IngeSoft.BicisBogota.Dto;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
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
public class ArriveDto {
    
    Integer Id_arrive;
    User user;
    Bicycle bicycle;
    Location location;

    public ArriveDto(Integer Id_arrive, User user, Bicycle bicycle, Location location ){
        this.Id_arrive = Id_arrive;
        this.user = user;
        this.bicycle = bicycle;
        this.location = location;
    }
    
}
