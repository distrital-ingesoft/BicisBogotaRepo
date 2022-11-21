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
    Integer idLocation;
    String location_name;
    String location_address;

    public LocationDto (Integer idLocation, String location_name, String location_address) {
        this.idLocation = idLocation;
        this.location_name = location_name;
        this.location_address = location_address;
    }
}
