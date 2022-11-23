package com.IngeSoft.BicisBogota.Repository;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Bicycle;

@Repository
public interface BicycleRepo extends JpaRepository<Bicycle,Integer>{
    
    List<Bicycle> findByIdBicycle(Integer id_bicycle);

    List<Bicycle> findByBrand(String brand);

    List<Bicycle> findByYear(Integer year);

    List<Bicycle> findByPrice(Double price);

    List<Bicycle> findByBorrowed(Boolean borrowed); 

    List<Bicycle> findByBrandAndYear (String brand, Integer year);

    List<Bicycle> findByBrandAndPrice (String brand, Double price);

    List<Bicycle> findByYearAndPrice (Integer year, Double price);

    List<Bicycle> findByYearBetween (Integer startYear, Integer endYear);

    List<Bicycle> findByPriceBetween (Double startPrice, Double endPrice);
    
}
