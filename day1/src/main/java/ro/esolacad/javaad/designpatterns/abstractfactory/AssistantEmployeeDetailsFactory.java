package ro.esolacad.javaad.designpatterns.abstractfactory;

public class AssistantEmployeeDetailsFactory implements EmployeeDetailsFactory{

    @Override
    public EmployeeReview createEmployeeReview() {
        return new AssistantEmployeeReview();
    }

    @Override
    public EmployeeHistory createEmployeeHistory() {
        return new AssistantEmployeeHistory();
    }
}
