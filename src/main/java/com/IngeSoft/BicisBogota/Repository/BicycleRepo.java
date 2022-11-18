package com.IngeSoft.BicisBogota.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.Bicycle;

@Repository
public interface BicycleRepo extends JpaRepository<Bicycle,Integer>{
    
    List<Bicycle> findByBicycleId(Integer Id_bicycle);

    List<Bicycle> findByBrand(String Brand);

    List<Bicycle> findByYear(Integer Year);

    List<Bicycle> finByPrice(Double Price);

    List<Bicycle> findByBorrowed(Boolean Borrowed); 

    List<Bicycle> findByBrandAndYear (String Brand, Integer Year);

    List<Bicycle> findByBrandAndPrice (String Brand, Double Price);

    List<Bicycle> findByYearAndPrice (Integer Year, Double Price);


}
