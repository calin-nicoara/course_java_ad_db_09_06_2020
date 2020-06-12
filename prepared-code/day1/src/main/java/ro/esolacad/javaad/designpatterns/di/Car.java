package ro.esolacad.javaad.designpatterns.di;

public class Car {
    private final Motor motor;

    public Car(final Motor motor) {
        this.motor = motor;
    }

    public void accelerate() {
        System.out.println("Car accelerating");
        this.motor.goFast();
    }
}
