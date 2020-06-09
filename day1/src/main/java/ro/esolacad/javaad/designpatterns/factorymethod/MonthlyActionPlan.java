package ro.esolacad.javaad.designpatterns.factorymethod;

import java.math.BigDecimal;

public abstract class MonthlyActionPlan {

    public void doMonthlyActivities() {
        Employee employee = getEmployee();

        System.out.println("I am an: " + employee.getTitle());
        employee.doJob();
        employee.paySalary(BigDecimal.valueOf(2000));
    }

    protected abstract Employee getEmployee();
}
