package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Benefits;

@Repository
public interface BenefitsRepo extends JpaRepository<Benefits,Integer>{
    
}
