package com.IngeSoft.BicisBogota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.IngeSoft.BicisBogota.Model.User;
import com.IngeSoft.BicisBogota.Repository.UserRepo;

@Component
public class InicializadorDatos implements CommandLineRunner{

    @Autowired
    UserRepo userRepo;

    InicializadorDatos(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inicializando Datos");

        User user = new User();
        user.setIdUser(1L);
        user.setEmail("ejemplo@ejemplo.com");
        user.setName("Otto");
        user.setPhone("111");
        user.setAdminMode(false);

        userRepo.save(user);

    }
    
}
