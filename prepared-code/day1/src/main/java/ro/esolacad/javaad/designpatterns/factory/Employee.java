package ro.esolacad.javaad.designpatterns.factory;

import java.math.BigDecimal;

interface Employee {

    String getJobTitle();
    void doJob();
    void paySalary(BigDecimal salary);
}
