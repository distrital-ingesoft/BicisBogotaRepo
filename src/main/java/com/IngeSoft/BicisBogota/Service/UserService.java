package com.IngeSoft.BicisBogota.Service;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Repository.UserRepo;
import com.IngeSoft.BicisBogota.Model.User;

@Component
public class UserService {

    private UserRepo repository;

    public UserService(UserRepo repository){
        this.repository=repository;
    }

    //Use of cases

    //1) Get All Users
    public Iterable<User> getAllUsers(){
        return this.repository.findAll();
    }

    //2) Create a new user if its ID is different to 123456
    public User addUser(User newUser) throws Exception{
        if(newUser.getId_user()==123456){
            throw new Exception("User is already added with 123456!");
        }else{
            return this.repository.save(newUser);
        }
    }

}
