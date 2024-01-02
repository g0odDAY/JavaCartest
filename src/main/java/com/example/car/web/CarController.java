package com.example.car.web;

import com.example.car.entity.Car;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @RequestMapping("/cars")
    public List<Car> getCars() {
        return carRepository.findAll();
    }
}
