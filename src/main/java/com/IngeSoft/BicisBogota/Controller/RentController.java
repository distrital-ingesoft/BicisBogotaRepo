package com.IngeSoft.BicisBogota.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;

import com.IngeSoft.BicisBogota.Service.RentService;
import com.IngeSoft.BicisBogota.Service.UserService;
import com.IngeSoft.BicisBogota.Service.BicycleService;
import com.IngeSoft.BicisBogota.Service.LocationService;

@RestController
public class RentController {

    @Autowired
    private RentService serviceRent;

    @Autowired
    private UserService serviceUser;

    @Autowired
    private BicycleService serviceBicycle;

    @Autowired
    private LocationService serviceLocation;

    public RentController (RentService serviceRent, UserService serviceUser, BicycleService serviceBicycle, LocationService serviceLocation) {
        this.serviceRent = serviceRent;
        this.serviceUser = serviceUser;
        this.serviceBicycle = serviceBicycle;
        this.serviceLocation = serviceLocation;
    }

    @GetMapping("/rents")
    public Iterable<Rent> readAllRents () {
        return this.serviceRent.getAllRents();
    }

    @PostMapping("/rents")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addRent (@RequestBody Rent newRent) throws Exception {
        Rent newrent = this.serviceRent.addRent(newRent);
        Bicycle bicycle = newRent.getBicycle();
        //Change bicycle status borrowed = true
        this.serviceBicycle.changeStatusBicycle(bicycle.getIdBicycle());
        return newrent.getDate().toString();
    }

    //users/{id}/rents?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/users/{id}/rents")
    public List<Rent> readAllRentsGivenUserAndDates (@PathVariable("id") String userId, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate ) throws Exception {
        Long id = Long.parseLong(userId);
        User user = this.serviceUser.findUser_id(id);  
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceRent.findRentsUser_periodTime(user,start,end);
    }

    //bicycles/{id}/rents?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/bicycles/{id}/rents")
    public List<Rent> readAllRentsGivenBicycleAndDates (@PathVariable("id") String bicycleId, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate) throws Exception {
        Integer id = Integer.parseInt(bicycleId);
        Bicycle bicycle = this.serviceBicycle.findBicycle_id(id);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceRent.findRentsBicycle_periodTime(bicycle,start,end);
    }

    //locations/{name}/rents?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/locations/{name}/rents")
    public List<Rent> readAllRentsGivenLocationAndDates (@PathVariable("name") String nameLocation, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate) throws Exception{
        Location location = this.serviceLocation.findLocation_name(nameLocation);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceRent.findRentsLocation_periodTime(location, start, end);
    }



    
}
