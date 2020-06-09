package ro.esolacad.javaad.designpatterns.abstractfactory;

public class AssistantEmployeeHistory implements EmployeeHistory{

    @Override
    public void showHistory() {
        System.out.println("This is my history as an ASsistant");
    }
}
