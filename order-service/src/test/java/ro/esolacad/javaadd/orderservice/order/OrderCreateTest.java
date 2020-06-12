package ro.esolacad.javaadd.orderservice.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OrderCreateTest {


    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        orderService.createOrder();
    }
}
