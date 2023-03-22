package com.ecommpackage;

import java.util.List;
import java.util.Objects;
import java.util.PrimitiveIterator.OfDouble;

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
        return new GreetResponse("Heeeeeellllllo", List.of("He", "Him", "Them"), new Person("Savita", 25, 108));
    }

    record Person(
        String name, 
        int age, 
        double money
    ){}

    record GreetResponse(
        String res,
        List<String> pronouns,
        Person person
    ){}

    //Implementation used before 'record' class for immutable objects
    // class GreetResponse{
    //     private final String greet;

    //     GreetResponse(String g){
    //         this.greet = g;
    //     }

    //     @Override
    //     public String toString() {
    //         return "GreetResponse{" + "greet='" + "\'" + "}";
    //     }

    //     public String getGreet(){
    //         return greet;
    //     }

    //     @Override
    //     public boolean equals(Object arg0) {
    //         if(this == arg0) return true;
    //         if(arg0 == null || getClass() != arg0.getClass()) return false;
    //         GreetResponse that = (GreetResponse) arg0;
    //         return Objects.equals(greet, that.greet);
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(greet);
    //     }
    // }
}
