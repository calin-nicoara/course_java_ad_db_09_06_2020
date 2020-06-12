package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarShopTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @Test
    @DisplayName("Get invoice for car")
    @Order(3)
    public void testGetInvoice() {
        CarRepairShop carRepairShop = new CarRepairShop();

        String carInvoiceText = carRepairShop.getCarInvoiceText("0001");

        assertEquals("Hello there!", carInvoiceText);
    }

    @Test
    @Tag("exceptional")
    @Order(2)
    public void testExceptions() {
        CarRepairShop carRepairShop = new CarRepairShop();

        InvoiceNotFoundException invoiceNotFoundException = assertThrows(InvoiceNotFoundException.class, () -> {
            carRepairShop.getCarInvoiceText("0002");
        });

        assertEquals(invoiceNotFoundException.getMessage(), "Invoice not found for 0002");
    }

    @Test
    @Disabled
    @Order(1)
    public void testWithAssumptionFalse() {
        Car car = new Car("0001", "FORD",
                BigDecimal.valueOf(12000), "CHROME RIMS", Car.OverallCondition.NEW);

        Assumptions.assumeTrue(car.getBrand().equals("BMW"));

        Assertions.fail();
    }

    @Test
    @Order(4)
    public void testWithAssumptionTrue() {
        Car car = new Car("0001", "FORD",
                BigDecimal.valueOf(12000), "CHROME RIMS", Car.OverallCondition.NEW);

        Assumptions.assumeTrue(car.getBrand().equals("FORD"));
    }

}
