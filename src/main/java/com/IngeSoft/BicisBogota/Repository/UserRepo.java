package com.IngeSoft.BicisBogota.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IngeSoft.BicisBogota.Dto.UserDto;
import com.IngeSoft.BicisBogota.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    // por defecto:
    // List<User> findAll();

    // lo puedo cambiar por un DTO
    // es una clase con los mismos nombres de atributos
    // List<UserDto> findAll();

    // proyección dinámica
    @Query("select u from User u")
    List<UserDto> findTodos();

    //Query methods to search for something

    List<User> findByIdUser(Long Id_user);

    List<User> findByName(String Name);

    List<User> findByEmail(String Email);

    List<User> findByPhone(String Phone);

    List<User> findByAdminMode(Boolean AdminMode);

    
    
}
