package ro.esolacad.javaad.designpatterns.factory;

import org.junit.jupiter.api.Test;

import java.util.List;

class EmployeeDetailsFactoryTest {

    @Test
    public void testFactory() {
        EmployeeDetailsFactory employeeDetailsFactory = new AssistantDetailsFactory();

        EmployeeHistory history = employeeDetailsFactory.getHistory();

        assert history.getFormerEmployees().containsAll(List.of("New Vision", "Computers are Us!"));

        EmployeeReview employeeReview = employeeDetailsFactory.getReview();

        assert employeeReview.getScore() != null;
    }
}
