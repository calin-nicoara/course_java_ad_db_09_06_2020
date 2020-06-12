package ro.esolacad.javaadd.orderservice.order;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class OrderCreatedEvent extends ApplicationEvent {

    @Getter
    private final OrderModel orderModel;

    public OrderCreatedEvent(final Object source, final OrderModel orderModel) {
        super(source);
        this.orderModel = orderModel;
    }

}
