package de.nexea.unitool.timeismoney.webclient.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Moin! meine erste Spring Boot App!";
    }
    
}
