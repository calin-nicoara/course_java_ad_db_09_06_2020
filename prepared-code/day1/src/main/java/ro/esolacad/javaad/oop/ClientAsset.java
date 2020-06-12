package ro.esolacad.javaad.oop;

import java.math.BigDecimal;

/**
 * Interface use to show polymorphism. This interface is implemented by
 * the Account and Mortgage class that share a contract.
 * This allows us to use any one of these to classes when a certain
 * piece of code uses just the contract found in ClientAssert.
 * Allows use to reuse code and also decouple our code.
 */
interface ClientAsset {

    BigDecimal getValue();
    String getClientId();
}
