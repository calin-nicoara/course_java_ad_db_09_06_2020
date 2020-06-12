package ro.esolacad.javaad.oop;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Account class that describes an account in a bank
 * This is a typical class the enforces encapsulation by
 * using getters and setters for interaction, however all fields being private
 */
class Account implements ClientAsset{

    private BigDecimal balance;
    private BigDecimal maximumAmount;
    private String clientId;
    private AccountType type;

    enum AccountType {
        DEBIT, CREDIT
    }

    public Account() {}

    public Account(final BigDecimal balance, final BigDecimal maximumAmount,
                   final String clientId, final AccountType type) {
        this.balance = balance;
        this.maximumAmount = maximumAmount;
        this.clientId = clientId;
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(final BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(final AccountType type) {
        this.type = type;
    }

    @Override
    public BigDecimal getValue() {
        return this.getBalance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, maximumAmount, clientId, type);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Account account = (Account) o;
        return Objects.equals(balance, account.balance) &&
                Objects.equals(maximumAmount, account.maximumAmount) &&
                Objects.equals(clientId, account.clientId) &&
                type == account.type;
    }
}
