package com.IngeSoft.BicisBogota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Model.User;
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

    InicializadorDatos(){}


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inicializando Datos");

        User user = new User();
        user.setIdUser(1L);
        user.setEmail("ejemplo@ejemplo.com");
        user.setName("Otto");
        user.setPhone("111");
        user.setAdminMode(false);
        userRepo.save(user);

        Location location = new Location();
        location.setLocation_name("Universidad Distrital");
        location.setLocation_address("La séptima");
      
        locationRepo.save(location);

        Bicycle bike = new Bicycle();
        bike.setIdBicycle(1);
        bike.setBrand("monark");
        bike.setYear(2022);
        bike.setPrice(1.0);
        bike.setBorrowed(false);
        bicycleRepo.save(bike);

        Rent rent = new Rent();
        rent.setUser(user);
        rent.setBicycle(bike);
        rent.setLocation(location);
        rentRepo.save(rent);
    }
    
}
