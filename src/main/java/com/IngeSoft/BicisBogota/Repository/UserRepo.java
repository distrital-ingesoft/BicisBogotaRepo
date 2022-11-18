package com.IngeSoft.BicisBogota.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    //Query methods to search for something

    List<User> findById(Long Id_user);

    List<User> finByName(String Name);

    List<User> findByEmail(String Email);

    List<User> finByPhone(String Phone);

    List<User> findByAdminMode(Boolean AdminMode);

    
    
}
