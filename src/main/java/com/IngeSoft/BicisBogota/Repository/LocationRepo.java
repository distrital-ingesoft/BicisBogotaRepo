package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer>{
    
}
