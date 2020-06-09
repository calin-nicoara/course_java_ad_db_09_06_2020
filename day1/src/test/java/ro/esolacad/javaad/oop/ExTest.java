package ro.esolacad.javaad.oop;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import ro.esolacad.javaad.oop.EarningsReporter;
import ro.esolacad.javaad.oop.NameIdentifier;
import ro.esolacad.javaad.oop.SuperUser;
import ro.esolacad.javaad.oop.User;

public class ExTest {

    @Test
    public void test() {
        System.out.println("Hello World!");

        User user = new User();
        user.setId("1");
        user.setAnnualSalary(BigDecimal.valueOf(12000));

        assert user != null;

        assert user.getMonthlySalary().compareTo(BigDecimal.valueOf(1000)) == 0;

        User user1 = new User("2", BigDecimal.valueOf(20000));

        assert user1 != null;
    }

    @Test
    public void testSuperUser() {
        SuperUser superUser = new SuperUser();
        superUser.setAnnualSalary(BigDecimal.valueOf(120000));
        superUser.setSuperAdmin(true);

        assert superUser.getMonthlySalary().compareTo(BigDecimal.valueOf(11000)) == 0;
        assert superUser.isSuperAdmin();

        User actuallySuperUser = superUser;

        assert actuallySuperUser.getMonthlySalary().compareTo(BigDecimal.valueOf(11000)) == 0;

        SuperUser superUser1 = new SuperUser("3", BigDecimal.valueOf(20000), true);

        assert superUser1 != null;
    }

    @Test
    public void testInterface() {
        NameIdentifier nameIdentifier = new User();

        assert nameIdentifier.getName() != null;

        EarningsReporter earningsReporter = new User();
    }
}
