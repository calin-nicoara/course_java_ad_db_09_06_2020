package ro.esolacad.javaad.java8andabove;

import org.junit.jupiter.api.Test;

public class NewInInterfacesTest {

    @Test
    public void testDefaultMethod() {
        Driver driver = new NormalDriver();

        driver.goForward();

        driver.makeAUTurn();
    }
}
