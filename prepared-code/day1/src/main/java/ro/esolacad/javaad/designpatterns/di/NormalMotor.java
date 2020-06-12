package ro.esolacad.javaad.designpatterns.di;

public class NormalMotor implements Motor {

    @Override
    public void goFast() {
        System.out.println("Going very fast");
    }
}
