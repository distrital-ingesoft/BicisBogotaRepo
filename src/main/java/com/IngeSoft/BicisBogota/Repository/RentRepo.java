package com.IngeSoft.BicisBogota.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Model.User;

@Repository
public interface RentRepo extends JpaRepository<Rent,Integer>{

    List<Rent> findByIdRent(Integer idRent);

    List<Rent> findByDate(LocalDate date);

    List<Rent> findByUser(User user);

    List<Rent> findByBicycle(Bicycle bicycle);

    List<Rent> findByLocation(Location location);

    List<Rent> findByUserAndDate(User user, LocalDate date);

    List<Rent> findByUserAndBicycle(User user, Bicycle bicycle);

    List<Rent> findByUserAndLocation(User user, LocalDate date);

    List<Rent> findByBicycleAndLocation(Bicycle bicycle, Location location);
    
}
