package ro.esolacad.javaad.oop;

import java.math.BigDecimal;

/**
 * Class that shows the concept of inheritance.
 * It retrieves all of the properties of an account, with the ability
 * to add its own implementation and override implementation from
 * its base class
 */
class PremiumAccount extends Account {

    private Integer premiumPoints;

    public PremiumAccount() {}

    public PremiumAccount(final BigDecimal balance, final BigDecimal maximumAmount, final String clientId, final AccountType type, final Integer premiumPoints) {
        super(balance, maximumAmount, clientId, type);
        this.premiumPoints = premiumPoints;
    }

    public Integer getPremiumPoints() {
        return premiumPoints;
    }

    public void setPremiumPoints(final Integer premiumPoints) {
        this.premiumPoints = premiumPoints;
    }

    /**
     * Here we see the PremiumAccount can override  behavior of the Account class.
     * However the contract must remain the same (visibility, name, parameter types and other
     * considerations)
     */
    @Override
    public void setBalance(final BigDecimal balance) {
        BigDecimal bonus = BigDecimal.valueOf(5);
        super.setBalance(balance.add(bonus));
    }
}
