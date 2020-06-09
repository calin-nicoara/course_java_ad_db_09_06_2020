package ro.esolacad.javaad.designpatterns.abstractfactory;

import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {

    @Test
    public void testFactory() {
        EmployeeDetailsFactory employeeDetailsFactory = new AssistantEmployeeDetailsFactory();

        EmployeeReview employeeReview = employeeDetailsFactory.createEmployeeReview();

        System.out.println(employeeReview.giveScore());

        EmployeeHistory employeeHistory = employeeDetailsFactory.createEmployeeHistory();

        employeeHistory.showHistory();
    }
}
