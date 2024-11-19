package com.ilearn.chk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentBarCodeCreateApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentBarCodeCreateApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StudentBarCodeFirstApp is running...");
    }
}
