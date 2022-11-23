package com.IngeSoft.BicisBogota.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Bicycle;
import com.IngeSoft.BicisBogota.Repository.BicycleRepo;

@Component
public class BicycleService {

    private BicycleRepo repository;

    public BicycleService(BicycleRepo repository){
        this.repository=repository;
    }
    
    //Use of cases

    //1) Get All Bicycles
    public Iterable<Bicycle> getAllBicycles(){
        return this.repository.findAll();
    }

    //2) Add a new Bicycle
    public Bicycle addBicycle (Bicycle newBicycle) throws Exception{
        List<Bicycle> list1 = this.repository.findByIdBicycle(newBicycle.getIdBicycle());
        boolean status1 = list1.isEmpty();
        if(status1 == false){
            throw new Exception("The bicycle's ID is already registered!");
        }else{
            return this.repository.save(newBicycle);
        }
    }

    //3) Search for a particular bicycle
    public Bicycle findBicycle_id(Integer id) throws Exception{
        List<Bicycle> list = this.repository.findByIdBicycle(id);
        Boolean status = list.isEmpty();

        if(status == true){
            throw new Exception("There is not Bicycle with this ID");
        }else{
            return list.get(0);
        }
    }

    //4) Delete a bicycle by ID
    public void deleteBicycle_id(Integer id) throws Exception{
        List<Bicycle> list = this.repository.findByIdBicycle(id);
        Boolean status = list.isEmpty();

        if(status == true){
            throw new Exception("There is not Bicycle with this ID");
        }else{
            this.repository.deleteById(id);
        }
    }

    //5) Change bicycle's status by id
    public void changeStatusBicycle (Integer Id) throws Exception{
        Bicycle bicycle = findBicycle_id(Id);
        Boolean status = bicycle.getBorrowed();
        bicycle.setBorrowed(!status);
    } 

    //6) Search bicycles by borrowed status
    public List<Bicycle> findBicycle_isBorrowed (Boolean borrowed ) throws Exception {
        List<Bicycle> bicycleIsBorrowed = this.repository.findByBorrowed(borrowed);
        
        if (bicycleIsBorrowed.isEmpty()) {
            throw new Exception("There are any bicycle with that borrowed status.");
        }else{
            return bicycleIsBorrowed;
        }
    }

    //7) Search bicycles registered between a Start year and End year
    public List<Bicycle> findBicycle_periodTime(Integer startYear, Integer endYear) throws Exception  {
        if (startYear > endYear) {
            throw new Exception("The start year is greater than end year. Start year must be lesser than End year.");
        }else{
            return this.repository.findByYearBetween(startYear, endYear);
        }
    }
    
    //8) Search bicycles within a price interval
    public List<Bicycle> findBicycle_PriceInterval (Double startPrice, Double endPrice) throws Exception {
        if(startPrice > endPrice) {
            throw new Exception("The start price is greater than end price. Start price must be lesser than end price.");
        }else{
            return this.repository.findByPriceBetween(startPrice, endPrice);
        }
    } 
}
