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
    Integer idBenefit;
    Integer noOfArrives;
    String description;

    public BenefitsDto (Integer idBenefit, Integer noOfArrives, String description) {
        this.idBenefit = idBenefit;
        this.noOfArrives = noOfArrives;
        this.description = description;
    }
}
