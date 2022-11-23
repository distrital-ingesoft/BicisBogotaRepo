package com.IngeSoft.BicisBogota.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Arrive;
import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Model.User;

@Repository
public interface ArriveRepo extends JpaRepository<Arrive,Integer>{

    List<Arrive> findByIdArrive (Integer idArrive);

    List<Arrive> findByDate (LocalDate date);

    List<Arrive> findByUser (User user);

    List<Arrive> findByBicycle (Bicycle bicycle);

    List<Arrive> findByLocation (Location location);

    List<Arrive> findByUserAndDate (User user, LocalDate date);

    List<Arrive> findByBicycleAndDate (Bicycle bicycle, LocalDate date);

    List<Arrive> findByUserAndBicycle (User user, Bicycle bicycle);

    List<Arrive> findByUserAndDateBetween(User User, LocalDate start, LocalDate end);


    
}
