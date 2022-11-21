package com.IngeSoft.BicisBogota.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location,Integer>{

    List<Location> findByIdLocation(Integer idLocation);

    List<Location> findByLocationName(String locationName);

    List<Location> findByLocationAddress( String locationAddress);

    
}
