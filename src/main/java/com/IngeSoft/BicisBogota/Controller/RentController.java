package com.IngeSoft.BicisBogota.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Model.Rent;
import com.IngeSoft.BicisBogota.Service.RentService;

@RestController
public class RentController {

    @Autowired
    private RentService service;

    public RentController (RentService service) {
        this.service = service;
    }

    @GetMapping("/rents")
    public Iterable<Rent> readAllRents () {
        return this.service.getAllRents();
    }

    @PostMapping("/rents")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addRent (@RequestBody Rent newRent) throws Exception {
        Rent newrent = this.service.addRent(newRent);
        return newrent.getDate().toString();
    }
    
}
