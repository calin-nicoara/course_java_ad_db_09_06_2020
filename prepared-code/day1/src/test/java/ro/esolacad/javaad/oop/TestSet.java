package ro.esolacad.javaad.oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class TestSet {

    @Test
    public void testSet() {
        Account account = new Account();
        account.setClientId("CL_1");
        account.setBalance(BigDecimal.valueOf(200));

        Set<Account> accountSet = new HashSet<>();

        accountSet.add(account);
        accountSet.add(account);

        assert 1 == accountSet.size();

        account.setClientId("CL_2");

        accountSet.add(account);

        assert 2 == accountSet.size();
    }
}
