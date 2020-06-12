package ro.esolacad.javaad.java8andabove;

public class NormalDriver implements Driver {
    @Override
    public void turnRight() {
        System.out.println("Normal right turn");
    }

    @Override
    public void goInReverse() {
        System.out.println("Normal go in reverse");
    }

    @Override
    public void turnLeft() {
        System.out.println("Normal left turn");
    }

    @Override
    public void goForward() {
        System.out.println("Normal go forward");
    }
}
