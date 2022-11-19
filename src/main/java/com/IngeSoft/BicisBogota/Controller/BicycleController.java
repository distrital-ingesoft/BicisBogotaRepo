package com.IngeSoft.BicisBogota.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Service.BicycleService;

@RestController
public class BicycleController {

    @Autowired
    private BicycleService service;

    public BicycleController (BicycleService service) {
        this.service = service;
    }

    @GetMapping("/bicycles")
    public Iterable<Bicycle> readAllBicycles () {
        return this.service.getAllBicycles();
    }
    
    @PostMapping("/bicycles")
    @ResponseStatus(code= HttpStatus.CREATED)
    public String addBicycle ( @RequestBody Bicycle newBicycle ) throws Exception{
        Bicycle newbicycle = this.service.addBicycle(newBicycle);
        return newbicycle.getIdBicycle().toString();
    }

    
}