package ro.esolacad.javaad.day4.product;

import org.springframework.context.ApplicationEvent;

public class ProductSearchEvent extends ApplicationEvent {
    private final String message;

    public ProductSearchEvent(final Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
