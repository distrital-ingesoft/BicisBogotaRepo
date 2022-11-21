package com.IngeSoft.BicisBogota.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Model.Arrive;
import com.IngeSoft.BicisBogota.Service.ArriveService;

@RestController
public class ArriveController {
    
    @Autowired
    private ArriveService service;

    public ArriveController (ArriveService service) {
        this.service = service;
    }

    @GetMapping("/arrives")
    public Iterable<Arrive> readAllArrives () {
        return this.service.getAllArrives();
    }

    @PostMapping("/arrives")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addArrive(@RequestBody Arrive newArrive) throws Exception {
        Arrive newarrive = this.service.addArrive(newArrive);
        return newarrive.getDate().toString();
    }
}
