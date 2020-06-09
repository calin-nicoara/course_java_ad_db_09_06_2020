package ro.esolacad.javaad.designpatterns.factorymethod;

import java.math.BigDecimal;

public class Executive implements Employee{

    private String name;
    private String title;

    public Executive(final String name, final String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void doJob() {
        System.out.println("did my job as an Executive");
    }

    public void paySalary(BigDecimal salary) {
        System.out.println("Got payed " + salary.multiply(BigDecimal.valueOf(2)));
    }
}
