package edu.gdut.juejinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.gdut")
public class JuejinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuejinServerApplication.class, args);
    }

}
