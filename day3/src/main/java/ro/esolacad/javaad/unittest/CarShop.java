package ro.esolacad.javaad.unittest;

import java.math.BigDecimal;

public class CarShop {

    private InvoiceCalculator invoiceCalculator;

    public CarShop(final InvoiceCalculator invoiceCalculator) {
        this.invoiceCalculator = invoiceCalculator;
    }

    public CarShop() {}

    public void showInvoice() {
        BigDecimal invoiceValue = invoiceCalculator.getInvoiceValue();

        invoiceCalculator.getInvoiceValue();
        System.out.println(invoiceValue);
    }
}
