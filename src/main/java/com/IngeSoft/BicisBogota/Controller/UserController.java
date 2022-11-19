package com.IngeSoft.BicisBogota.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.IngeSoft.BicisBogota.Dto.UserDto;
import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService service;
    
    public UserController (UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    public Iterable<User> readAllUsers(){
        return this.service.getAllUsers();
    }

    // mapeo requiere un DTO
    // -- a un objeto -- convierta a otro objeto
    // 
    // proyección requiere un DTO
    // -- en la consulta, jpa hace la conversión
    // 
    // serialización -- se puede hacer un serializador
    // -- con el JsonIgnore, al momento de convertir el objeto a JSON
    // -- le quité campo
    @GetMapping("/userdtos")
    public Iterable<UserDto> readAllUserDtos() {
        return this.service.getAllUserDto();
    }

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addUser (@RequestBody User newUser) throws Exception {
        User newuser = this.service.addUser(newUser);
        return newuser.getEmail();
    }



    
}