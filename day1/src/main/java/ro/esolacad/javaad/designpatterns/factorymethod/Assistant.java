package ro.esolacad.javaad.designpatterns.factorymethod;

import java.math.BigDecimal;

public class Assistant implements Employee{

    private String name;
    private String title;

    public Assistant(final String name, final String title) {
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
        System.out.println("did my job as an Assitant");
    }

    public void paySalary(BigDecimal salary) {
        System.out.println("Got payed " + salary);
    }
}
