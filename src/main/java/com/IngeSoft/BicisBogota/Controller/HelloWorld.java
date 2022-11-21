package com.IngeSoft.BicisBogota.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String getMessage(){
        return "Hello World <p>"
        +"<hr/>"
        + "<ul>"
        + "<li><a href=\"./users\">Users</a></li>"
        + "<li><a href=\"./bicycles\">Bicycles</a></li>"
        + "<li><a href=\"./locations\">Locations</a></li>"
        + "<li><a href=\"./arrives\">Arrives</a></li>"
        + "<li><a href=\"./rents\">Rents</a></li>"
        + "</ul>";
    }
}
