package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class CarShopTest {

    InvoiceCalculator invoiceCalculator = Mockito.mock(InvoiceCalculator.class);

    CarShop carShop = new CarShop(invoiceCalculator);

    @Test
    public void testShowInvoice() {
        Mockito.when(invoiceCalculator.getInvoiceValue()).thenReturn(BigDecimal.valueOf(100));

        carShop.showInvoice();

        Mockito.verify(invoiceCalculator, Mockito.times(1)).getInvoiceValue();
        Mockito.verifyNoMoreInteractions(invoiceCalculator);
    }
}
