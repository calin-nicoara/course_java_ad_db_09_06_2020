package ro.esolacad.javaad.designpatterns.abstractfactory;

public class AssistantEmployeeReview implements EmployeeReview{
    @Override
    public Integer giveScore() {
        return 5;
    }
}
