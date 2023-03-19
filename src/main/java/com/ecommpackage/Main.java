package com.ecommpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String args[]){
        //System.out.println("Hello");
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }

    @GetMapping("/greet")
    public GreetResponse greetJSON(){
        return new GreetResponse("Heeeeeellllllo");
    }

    record GreetResponse(String res){}
}
