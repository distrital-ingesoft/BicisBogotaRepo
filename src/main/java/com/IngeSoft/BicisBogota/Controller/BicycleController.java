package com.IngeSoft.BicisBogota.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    // /bicycles/search?startYear=2020&endYear=2021
    @GetMapping("/bicycles/search/years")
    public List<Bicycle> readBicyclesGivenYears (@RequestParam(name="startYear",required=false) String startYear, @RequestParam(name="endYear",required=false) String endYear) throws Exception {
        Integer start = Integer.parseInt(startYear);
        Integer end = Integer.parseInt(endYear);

        return this.service.findBicycle_periodTime(start, end);
    }

    // /bicycle/search/price?startPrice=100&endPrice=200
    @GetMapping("/bicycle/search/price")
    public List<Bicycle> readBicycleGivenPrices (@RequestParam(name="startPrice",required=false) String startPrice, @RequestParam(name="endPrice",required=false) String endPrice) throws Exception {
        Double  start = Double.parseDouble(startPrice);
        Double end = Double.parseDouble(endPrice);
        return this.service.findBicycle_PriceInterval(start, end);
    }

    
}