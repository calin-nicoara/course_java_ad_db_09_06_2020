package ro.esolacad.javaad.oop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

class Mortgage implements ClientAsset, Refundable {

    private BigDecimal valueOfCredit;
    private BigDecimal montageLeftToPay;
    private BigDecimal monthlyPayment;
    private String clientId;

    public Mortgage() {}

    public Mortgage(final BigDecimal valueOfCredit, final BigDecimal montageLeftToPay,
                    final BigDecimal monthlyPayment, final String clientId) {
        this.valueOfCredit = valueOfCredit;
        this.montageLeftToPay = montageLeftToPay;
        this.monthlyPayment = monthlyPayment;
        this.clientId = clientId;
    }

    public BigDecimal getValueOfCredit() {
        return valueOfCredit;
    }

    public void setValueOfCredit(final BigDecimal valueOfCredit) {
        this.valueOfCredit = valueOfCredit;
    }

    public BigDecimal getMortgageLeftToPay() {
        return montageLeftToPay;
    }

    public void setMontageLeftToPay(final BigDecimal montageLeftToPay) {
        this.montageLeftToPay = montageLeftToPay;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(final BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    /**
     * Used by the ClientAssert interface
     */
    @Override
    public BigDecimal getValue() {
        return this.getMortgageLeftToPay();
    }

    /**
     * Method that shows data abstraction.
     *
     */
    public Integer getMonthsLeftForPayment() {
        return this.getMortgageLeftToPay().
                divide(this.getMonthlyPayment(), 2, RoundingMode.FLOOR)
                .intValue();
    }

    @Override
    public BigDecimal getRefundTax() {
        return this.getMortgageLeftToPay().multiply(BigDecimal.valueOf(1.25)).setScale(2, RoundingMode.FLOOR);
    }

    @Override
    public Boolean getIsRefundable() {
        return true;
    }
}
