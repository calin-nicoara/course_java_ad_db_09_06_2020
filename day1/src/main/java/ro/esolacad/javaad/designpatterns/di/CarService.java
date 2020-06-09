package ro.esolacad.javaad.designpatterns.di;

public class CarService {

    private final MotorService motorService;

    public CarService(final MotorService motorService) {
        this.motorService = motorService;
    }

//    public CarService() {
//
//    }
//
//    public void setMotorService(MotorService motorService) {
//        this.motorService = motorService;
//    }

    public void accelerate() {
        System.out.println("Car accelerating");
        this.motorService.goFast();
    }
}
