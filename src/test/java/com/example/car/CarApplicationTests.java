package com.example.car;

import com.example.car.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarApplicationTests {
    @Autowired
    private CarController carController;
    @Test
    @DisplayName("First example test case")
    void contextLoads() {
        assertThat(carController).isNotNull();
    }

}
