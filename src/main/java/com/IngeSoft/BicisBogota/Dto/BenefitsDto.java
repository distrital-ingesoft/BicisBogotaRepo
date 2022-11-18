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

public class BenefitsDto {
    Integer Id_benefit;
    Integer NoOfArrives;
    String Description;

    public BenefitsDto (Integer Id_benefit, Integer NoOfArrives, String Description) {
        this.Id_benefit = Id_benefit;
        this.NoOfArrives = NoOfArrives;
        this.Description = Description;
    }
}
