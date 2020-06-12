package ro.esolacad.javaad.designpatterns.factory;

import java.math.BigDecimal;

class ExecutiveEmployee implements Employee {
    @Override
    public String getJobTitle() {
        return "Executive";
    }

    @Override
    public void doJob() {
        System.out.println("Did my very executive job!");
    }

    @Override
    public void paySalary(final BigDecimal salary) {
        System.out.println("I got payed: " + salary + " plus bonus " +
                salary.multiply(BigDecimal.valueOf(0.15)));
    }
}
