package ro.esolacad.javaad.designpatterns.di;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void testThis() {
        Motor motor = new NormalMotor();
        Car car = new Car(motor);

        car.accelerate();
    }
}
