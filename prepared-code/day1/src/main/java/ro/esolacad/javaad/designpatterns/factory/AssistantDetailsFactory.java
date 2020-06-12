package ro.esolacad.javaad.designpatterns.factory;

class AssistantDetailsFactory implements EmployeeDetailsFactory {
    @Override
    public EmployeeReview getReview() {
        return new AssistantReview();
    }

    @Override
    public EmployeeHistory getHistory() {
        return new AssistantHistory();
    }
}
