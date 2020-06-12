package ro.esolacad.javaad.oop;

import java.math.BigDecimal;

class OOPMain {

    public static void main(String[] args) {
        encapsulation();
        Mortgage mortgage = dataAbstraction();
        polymorphism(mortgage);
        inheritance();
    }

    private static void encapsulation() {
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(200));
        account.setClientId("CL_1");

        System.out.println("Client id");
        System.out.println(account.getClientId());
        System.out.println();
    }

    private static Mortgage dataAbstraction() {
        Mortgage mortgage = new Mortgage();
        mortgage.setClientId("CL_2");
        mortgage.setMontageLeftToPay(BigDecimal.valueOf(235000.50));
        mortgage.setMonthlyPayment(BigDecimal.valueOf(1375.54));

        System.out.println("Months left for payment");
        System.out.println(mortgage.getMonthsLeftForPayment());
        System.out.println();
        return mortgage;
    }

    private static void polymorphism(final Mortgage mortgage) {
        // Polymorphism
        ClientAsset clientAsset = mortgage;
        Refundable refundable = mortgage;

        System.out.println("Polymorphism from mortgage class with two interfaces");
        System.out.println(clientAsset.getClientId());
        System.out.println(refundable.getIsRefundable());
    }

    private static void inheritance() {
        // Inheritance
        PremiumAccount premiumAccount = new PremiumAccount();
        premiumAccount.setPremiumPoints(5);
        premiumAccount.setClientId("CL_3");
        premiumAccount.setBalance(BigDecimal.valueOf(20));

        System.out.println("Show method available just in PremiumAccount");
        System.out.println(premiumAccount.getPremiumPoints());

        Account account = premiumAccount;
        System.out.println("Show overriden behaviour from PremiumAccount");
        System.out.println(account.getBalance());
    }
}
