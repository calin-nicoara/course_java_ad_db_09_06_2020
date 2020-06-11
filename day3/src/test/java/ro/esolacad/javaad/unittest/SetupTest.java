package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SetupTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEAch() {
        System.out.println("Before each");
    }

    @Test
    @Order(3)
    public void testSomething() {
        System.out.println("TEst 1");
    }

    @Test
    @Order(1)
    public void testSomething2() {
        System.out.println("TEst 2");
    }

    @Test
    @Order(2)
    public void testSomething3() {
        System.out.println("TEst 3");
    }

    @Test
    public void testException() {
        CarShop carShop = new CarShop();

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            carShop.showInvoice();
        });

        assertEquals("No invoice!", runtimeException.getMessage());
    }


}
