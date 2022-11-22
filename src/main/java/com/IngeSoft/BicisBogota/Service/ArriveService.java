package com.IngeSoft.BicisBogota.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Arrive;
import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Repository.ArriveRepo;


@Component
public class ArriveService {

    private ArriveRepo repository;

    public ArriveService (ArriveRepo repository) {
        this.repository = repository;
    }

    //Use of cases

    //1)Get all arrives
    public Iterable<Arrive> getAllArrives() {
        return this.repository.findAll();
    }

    //2) Create a new arrive with a date, user, bicycle and location if is not already exist an arrive with the same date for that user 
    public Arrive addArrive (Arrive newArrive) throws Exception {
        List<Arrive> arrivesUsuarioConMismaFecha = this.repository.findByUserAndDate(newArrive.getUser(), newArrive.getDate());

        if(!arrivesUsuarioConMismaFecha.isEmpty()) {
            throw new Exception("There is already an arrived registered for this user today");
        }else{
            return this.repository.save(newArrive);
        }
    }

    //3)Search for arrives given a user
    public List<Arrive> findArrives_user (User user) throws Exception {
        List<Arrive> arrivesGivenAUser = this.repository.findByUser(user);
        if(!arrivesGivenAUser.isEmpty()) {
            throw new Exception("There is any arrives for this user");
        }else{
            return arrivesGivenAUser;
        }
    }

    //4) Search for arrives given a bicycle
    public List<Arrive> findArrives_bicycle (Bicycle bicycle) throws Exception {
        List<Arrive> arrivesGivenABike = this.repository.findByBicycle(bicycle);
        if(!arrivesGivenABike.isEmpty()){
            throw new Exception("There is any arrives for this bicycle");
        }else{
            return arrivesGivenABike;
        }
    }

    //5) Search for arrives given a date
    public List<Arrive> findArrives_date (LocalDate date) throws Exception {
        List<Arrive> arrivesGivenADate = this.repository.findByDate(date);
        if(!arrivesGivenADate.isEmpty()) {
            throw new Exception("There is any arrives for this date");
        }else{
            return arrivesGivenADate;
        }
    }

    //6) Search for arrives given a user name and a date of beginning
    //public 

}
