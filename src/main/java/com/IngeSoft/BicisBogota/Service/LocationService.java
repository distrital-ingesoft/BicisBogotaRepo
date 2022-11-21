package com.IngeSoft.BicisBogota.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.Location;
import com.IngeSoft.BicisBogota.Repository.LocationRepo;

@Component
public class LocationService {
    private LocationRepo repository;

    public LocationService(LocationRepo repository){
        this.repository = repository;
    }

    //Use of cases

    //1) Get all locations
    public Iterable<Location> getAllLocations(){
        return this.repository.findAll();
    }

    //2)Create a new location with name and address if these arguments aren't already registered
    public Location addLocation(Location newLocation) throws Exception {
        List<Location> LocationsConMismoNombre = this.repository.findByLocationName(newLocation.getLocationName());
        List<Location> LocationsConMismaDireccion = this.repository.findByLocationAddress(newLocation.getLocationAddress());
        
        if(!LocationsConMismoNombre.isEmpty()){
            throw new Exception("Location's name is already registered");
        }else if(!LocationsConMismaDireccion.isEmpty()){
            throw new Exception("Location's address is already registered");
        }else{
            return this.repository.save(newLocation);
        }
    }

    //3)Search for a particular location's name
    public Location findLocation_name(String name) throws Exception{
        List<Location> locationsConMismoNombre = this.repository.findByLocationName(name);

        if(!locationsConMismoNombre.isEmpty()){
            throw new Exception("There is not Location with this name");
        }else{
            return locationsConMismoNombre.get(0);
        }
    }

    //4)Deleted a particular location
    public void deleteLocation_name(String name) throws Exception{
        List<Location> locationsConMismoNombre = this.repository.findByLocationName(name);
        if(!locationsConMismoNombre.isEmpty()){
            throw new Exception("There is not Location with this name");
        }else{
            Location location = findLocation_name(name);
            this.repository.deleteById(location.getIdLocation());
        }

    } 




    
}
