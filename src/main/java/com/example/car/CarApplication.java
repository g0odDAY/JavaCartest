package com.example.car;

import com.example.car.entity.Car;
import com.example.car.entity.Owner;
import com.example.car.entity.User;
import com.example.car.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.car.repository.CarRepository;
import com.example.car.repository.OwnerRepository;

import java.util.Arrays;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CarApplication.class);
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        // Add car object and link to owners and save these to db
        Car car1 = new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2021, 59000, owner1);
        Car car2 = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2019, 29000, owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2020, 39000, owner2);
        carRepository.saveAll(Arrays.asList(car1, car2, car3));

        for (Car car : carRepository.findAll()) {
            logger.info(car.toString());
        }
        userRepository.save(new User("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
        userRepository.save(new User("admin",
                "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }

}
