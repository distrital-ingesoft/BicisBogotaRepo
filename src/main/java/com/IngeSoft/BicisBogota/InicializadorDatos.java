package com.IngeSoft.BicisBogota;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Arrive;
import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Repository.ArriveRepo;
import com.IngeSoft.BicisBogota.Repository.BicycleRepo;
import com.IngeSoft.BicisBogota.Repository.LocationRepo;
import com.IngeSoft.BicisBogota.Repository.RentRepo;
import com.IngeSoft.BicisBogota.Repository.UserRepo;

@Component
public class InicializadorDatos implements CommandLineRunner{

    @Autowired
    UserRepo userRepo;
    
    @Autowired
    BicycleRepo bicycleRepo; 

    @Autowired
    LocationRepo locationRepo;

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ArriveRepo arriveRepo;

    InicializadorDatos(){}


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inicializando Datos");

        User user = new User();
        user.setIdUser(103070217L);
        user.setEmail("jperezr@gmail.com");
        user.setName("Julian");
        user.setPhone("+57 3057245633");
        user.setAdminMode(false);
        userRepo.save(user);

        Location location = new Location();
        location.setLocationName("Universidad Distrital");
        location.setLocationAddress("La séptima");
      
        locationRepo.save(location);

        Bicycle bike = new Bicycle();
        bike.setIdBicycle(1);
        bike.setBrand("Specialized");
        bike.setYear(2022);
        bike.setPrice(1000.0);
        bike.setBorrowed(false);
        bicycleRepo.save(bike);

        Rent rent = new Rent();
        rent.setUser(user);
        rent.setBicycle(bike);
        rent.setLocation(location);
        rent.setDate(LocalDate.now());
        rentRepo.save(rent);

        Arrive arrive = new Arrive();
        arrive.setDate(LocalDate.parse("2022-10-21"));
        arrive.setUser(user);
        arrive.setBicycle(bike);
        arrive.setLocation(location);
        arriveRepo.save(arrive);

        Arrive arrive = new Arrive();
        arrive.setDate(LocalDate.parse("2022-10-22"));
        arrive.setUser(user);
        arrive.setBicycle(bike);
        arrive.setLocation(location);
        arriveRepo.save(arrive);

        Arrive arrive = new Arrive();
        arrive.setDate(LocalDate.parse("2022-10-23"));
        arrive.setUser(user);
        arrive.setBicycle(bike);
        arrive.setLocation(location);
        arriveRepo.save(arrive);
    }
    
}
