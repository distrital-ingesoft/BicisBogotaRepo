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
    Integer Id_bicycle;
    String Brand;
    Integer Year;
    Double Price;
    Boolean Borrowed;

    public BicycleDto (Integer Id_bicycle, String Brand, Integer Year, Double Price, Boolean Borrowed) {
        this.Id_bicycle = Id_bicycle;
        this.Brand = Brand;
        this.Year = Year;
        this.Price = Price;
        this.Borrowed = Borrowed;
    }
}
