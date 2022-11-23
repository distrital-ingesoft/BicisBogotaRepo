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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.IngeSoft.BicisBogota.Model.Arrive;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Model.Location;

import com.IngeSoft.BicisBogota.Service.ArriveService;
import com.IngeSoft.BicisBogota.Service.UserService;
import com.IngeSoft.BicisBogota.Service.BicycleService;
import com.IngeSoft.BicisBogota.Service.LocationService;

@RestController
public class ArriveController {
    
    @Autowired
    private ArriveService serviceArrive;

    @Autowired
    private UserService serviceUser;

    @Autowired
    private BicycleService serviceBicycle;

    @Autowired
    private LocationService serviceLocation;

    public ArriveController (ArriveService serviceArrive, UserService serviceUser, BicycleService serviceBicycle, LocationService serviceLocation) {
        this.serviceArrive = serviceArrive;
        this.serviceUser = serviceUser;
        this.serviceBicycle = serviceBicycle;
        this.serviceLocation = serviceLocation;
    }

    @GetMapping("/arrives")
    public Iterable<Arrive> readAllArrives () {
        return this.serviceArrive.getAllArrives();
    }

    @PostMapping("/arrives")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addArrive(@RequestBody Arrive newArrive) throws Exception {
        Arrive newarrive = this.serviceArrive.addArrive(newArrive);
        return newarrive.getDate().toString();
    }
    
    ///users/{id}/arrives?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/users/{id}/arrives")
    public List<Arrive> readAllArrivesGivenUserAndDates (@PathVariable("id") String userId, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate ) throws Exception {
        Long id = Long.parseLong(userId);
        User user = this.serviceUser.findUser_id(id);  
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceArrive.findArrivesUser_periodTime(user,start,end);
    }

    //bicycles/{id}/arrives?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/bicycles/{id}/arrives")
    public List<Arrive> readAllArrivesGivenBicycleAndDates (@PathVariable("id") String bicycleId, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate) throws Exception {
        Integer id = Integer.parseInt(bicycleId);
        Bicycle bicycle = this.serviceBicycle.findBicycle_id(id);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceArrive.findArrivesBicycles_periodTime(bicycle,start,end);
    }

    //locations/{name}/arrives?startDate=2022-10-21&endDate=2022-11-21
    @GetMapping("/locations/{name}/arrives")
    public List<Arrive> readAllArrivesGivenLocationAndDates (@PathVariable("name") String nameLocation, @RequestParam(name="startDate",required=false) String startDate, @RequestParam(name="endDate",required=false) String endDate) throws Exception{
        Location location = this.serviceLocation.findLocation_name(nameLocation);
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return this.serviceArrive.findArrivesLocation_periodTime(location, start, end);
    }
}
