package ro.esolacad.javaad.designpatterns.di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    public void testCarService() {

        CarService carService = new CarService(new RaceMotorService());

        carService.accelerate();

//        CarService carService1 = new CarService();
//        carService1.setMotorService(new MotorService());
    }

}
