package ro.esolacad.javaadd.orderservice.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import ro.esolacad.javaadd.orderservice.email.EmailService;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void createOrder() {
        // Create order
        OrderModel orderModel = new OrderModel(1L);

        applicationEventPublisher.publishEvent(new OrderCreatedEvent(this,
                orderModel));
    }
}
