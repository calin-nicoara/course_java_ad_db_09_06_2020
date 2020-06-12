package ro.esolacad.javaad.unittest;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(final String message) {
        super(message);
    }
}
