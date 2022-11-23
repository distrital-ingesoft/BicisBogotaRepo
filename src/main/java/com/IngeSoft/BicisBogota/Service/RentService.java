package com.IngeSoft.BicisBogota.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Repository.RentRepo;

@Component
public class RentService {
    
    private RentRepo repository;
    
    public RentService (RentRepo repository) {
        this.repository = repository;
    }

    //Use of cases

    //1)Get all rents
    public Iterable<Rent> getAllRents (){
        return this.repository.findAll();
    }

    //2)Create a new rent with a date, user, bicycle and location if is not already exist a rent with the same date for that user 
    public Rent addRent (Rent newRent) throws Exception {
        List<Rent> rentsUsuarioConMismaFecha = this.repository.findByUserAndDate(newRent.getUser(),newRent.getDate());
        if(!rentsUsuarioConMismaFecha.isEmpty()){
            throw new Exception("There is already registered for this user a rent today");
        }else{
            return this.repository.save(newRent);
        }
    }

    //3)Search for rents given a user
    public List<Rent> findRents_user (User user) throws Exception {
        List<Rent> rentsGivenAUser = this.repository.findByUser(user);
        if(!rentsGivenAUser.isEmpty()){
            throw new Exception("There is any rents for this user");
        }else{
            return rentsGivenAUser;
        }
    }

    //4)Search for rents given a bicycle
    public List<Rent> findRents_bicycle (Bicycle bicycle) throws Exception {
        List<Rent> rentsGivenABike = this.repository.findByBicycle(bicycle);
        if(!rentsGivenABike.isEmpty()){
            throw new Exception("There is any rents for this bicycle");
        }else{
            return rentsGivenABike;
        }
    }

    //5) Search for rents given a date
    public List<Rent> findRents_date (LocalDate date) throws Exception {
        List<Rent> rentsGivenADate = this.repository.findByDate(date);
        if(!rentsGivenADate.isEmpty()){
            throw new Exception("There is any rents for today");
        }else{
            return rentsGivenADate;
        }
    }

    //5) Search for rents given a location
    public List<Rent> findRents_location (Location location) throws Exception {
        List<Rent> rentsGivenALocation = this.repository.findByLocation(location);
        if(!rentsGivenALocation.isEmpty()){
            throw new Exception("There is any rents for this location");   
        }else{
            return rentsGivenALocation;
        }
    }

    //6)Search for rentals given a user, a date of beginning and a date of ending
    public List<Rent> findRentsUser_periodTime (User user, LocalDate start, LocalDate end) throws Exception{
        Boolean isBefore = end.isBefore(start);
        Boolean isEqual = end.isEqual(start);

        if (isBefore) {
            throw new Exception("End date is before to Start date. End date must be  after of start date");
        }else if (isEqual) {
            throw new Exception("Start and End dates are equal. Start date must be before of End date");
        }else {
            return this.repository.findByUserAndDateBetween (user, start,end);
        }   
    }

    //7) Search for rentals given a bicycle, a date of beginning and a date of ending
    public List<Rent> findRentsBicycle_periodTime (Bicycle bicycle, LocalDate start, LocalDate end) throws Exception{
        Boolean isBefore = end.isBefore(start);
        Boolean isEqual = end.isEqual(start);

        if (isBefore) {
            throw new Exception("End date is before to Start date. End date must be  after of start date");
        }else if (isEqual) {
            throw new Exception("Start and End dates are equal. Start date must be before of End date");
        }else {
            return this.repository.findByBicycleAndDateBetween (bicycle, start, end);
        }   
    }    

    //8) Search for rentals given a location, a date of beginning and a date of ending
    public List<Rent> findRentsLocation_periodTime (Location location, LocalDate start, LocalDate end) throws Exception{
        Boolean isBefore = end.isBefore(start);
        Boolean isEqual = end.isEqual(start);

        if (isBefore) {
            throw new Exception("End date is before to Start date. End date must be  after of start date");
        }else if (isEqual) {
            throw new Exception("Start and End dates are equal. Start date must be before of End date");
        }else {
            return this.repository.findByLocationAndDateBetween (location, start,end);
        }   
    }
}
