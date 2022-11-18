package com.IngeSoft.BicisBogota.Dto;

//import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class LocationDto {
    Integer Id_location;
    String Location_name;
    String Location_address;

    public LocationDto (Integer Id_location, String Location_name, String Location_address) {
        this.Id_location = Id_location;
        this.Location_name = Location_name;
        this.Location_address = Location_address;
    }
}
