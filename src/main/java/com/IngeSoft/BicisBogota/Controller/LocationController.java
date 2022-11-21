package com.IngeSoft.BicisBogota.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Service.LocationService;

@RestController
public class LocationController {

    @Autowired
    private LocationService service;

    public LocationController (LocationService service) {
        this.service = service;
    }

    @GetMapping("/locations")
    public Iterable<Location> readAllLocations() {
        return this.service.getAllLocations();
    }

    @PostMapping("/locations")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addLocation (@RequestBody Location newLocation) throws Exception {
        Location newlocation = this.service.addLocation(newLocation);
        return newlocation.getLocationName(); 
    }


    
}
