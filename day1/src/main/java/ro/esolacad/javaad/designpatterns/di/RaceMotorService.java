package ro.esolacad.javaad.designpatterns.di;

public class RaceMotorService implements MotorService{
    @Override
    public void goFast() {
        System.out.println("RAce car go fast!");
    }
}
