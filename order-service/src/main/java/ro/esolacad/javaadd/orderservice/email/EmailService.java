package ro.esolacad.javaadd.orderservice.email;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import ro.esolacad.javaadd.orderservice.order.OrderCreatedEvent;

@Service
public class EmailService {

    @EventListener
    public void sendEmail(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("Order received for email: " + orderCreatedEvent.getOrderModel().getId());
    }
}
