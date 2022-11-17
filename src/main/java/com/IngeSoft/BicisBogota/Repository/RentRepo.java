package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Rent;

@Repository
public interface RentRepo extends JpaRepository<Rent,Integer>{
    
}
