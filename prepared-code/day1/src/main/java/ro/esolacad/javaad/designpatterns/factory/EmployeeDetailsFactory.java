package ro.esolacad.javaad.designpatterns.factory;

interface EmployeeDetailsFactory {

    EmployeeReview getReview();

    EmployeeHistory getHistory();
}
