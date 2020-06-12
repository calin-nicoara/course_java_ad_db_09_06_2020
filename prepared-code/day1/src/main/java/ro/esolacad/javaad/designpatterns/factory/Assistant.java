package ro.esolacad.javaad.designpatterns.factory;

import java.math.BigDecimal;

class Assistant implements Employee{

    @Override
    public String getJobTitle() {
        return "Assistant";
    }

    @Override
    public void doJob() {
        System.out.println("I did my job!");
    }

    @Override
    public void paySalary(final BigDecimal baseSalary) {
        System.out.println("Got payed: " + baseSalary);
    }

}
