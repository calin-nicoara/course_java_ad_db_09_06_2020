package ro.esolacad.javaad.designpatterns.factory;

import java.math.BigDecimal;

abstract class MonthlyActionPlan {

    public void doMonthlyActivities() {
        Employee employee = getEmployee();

        System.out.println("I am an: " + employee.getJobTitle());
        employee.doJob();
        employee.paySalary(BigDecimal.valueOf(2000));
    }

    protected abstract Employee getEmployee();
}
