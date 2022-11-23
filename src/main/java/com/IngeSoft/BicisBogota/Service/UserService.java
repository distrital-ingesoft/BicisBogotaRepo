package com.IngeSoft.BicisBogota.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Repository.UserRepo;
import com.IngeSoft.BicisBogota.Dto.UserDto;
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

    public Iterable<UserDto> getAllUserDto() {
        return (Iterable<UserDto>) this.repository.findTodos();
    }

    //2) Create a new user if the ID and Email are not exit already
    public User addUser(User newUser) throws Exception{
        
        List<User> usuariosConMismoNombre = this.repository.findByIdUser(newUser.getIdUser());
        List<User> usuariosConMismoEmail = this.repository.findByEmail(newUser.getEmail());
        List<User> usuariosConMismoTel = this.repository.findByPhone(newUser.getPhone());

        if(!usuariosConMismoNombre.isEmpty()){
            throw new Exception("The user's ID is already registered!");
        }else if (!usuariosConMismoEmail.isEmpty()){
            throw new Exception("The user's Email is already registered!");
        }else if (!usuariosConMismoTel.isEmpty()) {
            throw new Exception("The user's Phone is already registered!");
        }
        else{
            return this.repository.save(newUser);
        }
    }

    //3) Search for a particular user by id
    public User findUser_id(Long id) throws Exception{
        List<User> usuarioConId = this.repository.findByIdUser(id);
        //Boolean status = list.isEmpty();

        if(!usuarioConId.isEmpty()){
            throw new Exception("There is not User with this ID");
        }else{
            return usuarioConId.get(0);
        }
    }

    //4) Delete a user by ID
    public void deleteUser_id(Long id) throws Exception{
        List<User> usuarioConId = this.repository.findByIdUser(id);
        //Boolean status = list.isEmpty();

        if(!usuarioConId.isEmpty()){
            throw new Exception("There is not User with this ID");
        }else{
            this.repository.deleteById(id);
        }
    }

    //5) Search for an user with the same name
    public List<User> findUser_name (String name) throws Exception{
        List<User> usuariosConMismoNombre = this.repository.findByName(name);

        if(usuariosConMismoNombre.isEmpty()){
            throw new Exception("There is any user with that name.");
        }else{
            return usuariosConMismoNombre;
        }
    }

    //6) Search for an user by email
    public User findUser_email (String email) throws Exception{
        List<User> usuarioConEmail = this.repository.findByEmail(email);
        if(usuarioConEmail.isEmpty()){
            throw new Exception("There is any user with that Email");
        }else{
            return usuarioConEmail.get(0);
        }
    } 




}
