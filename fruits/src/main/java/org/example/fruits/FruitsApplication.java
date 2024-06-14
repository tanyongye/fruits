package org.example.fruits;

import org.example.fruits.web.CalculateController;
import org.example.fruits.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FruitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruitsApplication.class, args);
    }

}
