package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Arrive;

@Repository
public interface ArriveRepo extends JpaRepository<Arrive,Integer>{
    
}
