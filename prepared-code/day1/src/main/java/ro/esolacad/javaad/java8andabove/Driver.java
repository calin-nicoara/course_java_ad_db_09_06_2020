package ro.esolacad.javaad.java8andabove;

import java.util.Random;

interface Driver {

    void turnRight();

    void goInReverse();

    default void makeAUTurn() {
        if (seeIfSafeToMakeUTurn()) {
            turnLeft();
            turnLeft();
            goForward();
        }
    }

    private boolean seeIfSafeToMakeUTurn() {
        return new Random().nextInt(100) % 2 == 0;
    }

    void turnLeft();

    void goForward();
}
