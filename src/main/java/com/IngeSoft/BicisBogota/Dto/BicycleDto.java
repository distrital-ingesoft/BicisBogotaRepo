package com.IngeSoft.BicisBogota.Dto;

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
public class BicycleDto {
    Integer idBicycle;
    String brand;
    Integer year;
    Double price;
    Boolean borrowed;

    public BicycleDto (Integer idBicycle, String brand, Integer year, Double price, Boolean borrowed) {
        this.idBicycle = idBicycle;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.borrowed = borrowed;
    }
}
