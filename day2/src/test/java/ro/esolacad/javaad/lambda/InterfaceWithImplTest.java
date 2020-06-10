package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceWithImplTest {

    @Test
    public void testInterface() {
        InterfaceWithImpl interfaceWithImplTest = new InterfaceWithImpl(){};

        interfaceWithImplTest.saySomething();


    }

}
