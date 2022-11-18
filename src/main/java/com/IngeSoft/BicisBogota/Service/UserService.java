package com.IngeSoft.BicisBogota.Service;

import java.util.List;

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

    //2) Create a new user if the ID and Email are not exit already
    public User addUser(User newUser) throws Exception{
        
        List<User> list1 = this.repository.findById(newUser.getId_user());
        List<User> list2 = this.repository.findByEmail(newUser.getEmail());
        
        boolean status1 = list1.isEmpty();
        boolean status2 = list2.isEmpty();

        if(status1 == false){
            throw new Exception("The user's ID is already registered!");
        }else if (status2 == false){
            throw new Exception("The user's Email is already registered!");
        }
        else{
            return this.repository.save(newUser);
        }
    }

    //3) Search for a particular user
    public User findUser_id(Long id) throws Exception{
        List<User> list = this.repository.findById(id);
        Boolean status = list.isEmpty();

        if(status == true){
            throw new Exception("There is not User with this ID");
        }else{
            return list.get(0);
        }
    }

    


}
