package ro.esolacad.javaad.designpatterns.abstractfactory;

public class CentralFactory {

    public static EmployeeDetailsFactory createEmployeeDetailsFactory(String type) {
        if(type.equals("assistant")) {
            return new AssistantEmployeeDetailsFactory();
        }

        return null;
    }
}
