package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Bicycle;

@Repository
public interface BicycleRepo extends JpaRepository<Bicycle,Integer>{
    
}
