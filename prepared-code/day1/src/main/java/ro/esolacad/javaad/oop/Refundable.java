package ro.esolacad.javaad.oop;

import java.math.BigDecimal;

public interface Refundable {

    BigDecimal getRefundTax();
    Boolean getIsRefundable();
}
