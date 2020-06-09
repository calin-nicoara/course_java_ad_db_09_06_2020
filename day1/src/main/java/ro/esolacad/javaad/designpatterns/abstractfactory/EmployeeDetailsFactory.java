package ro.esolacad.javaad.designpatterns.abstractfactory;

public interface EmployeeDetailsFactory {
    EmployeeReview createEmployeeReview();
    EmployeeHistory createEmployeeHistory();
}
