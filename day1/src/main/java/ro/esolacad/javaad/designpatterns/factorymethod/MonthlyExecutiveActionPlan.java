package ro.esolacad.javaad.designpatterns.factorymethod;

public class MonthlyExecutiveActionPlan extends MonthlyActionPlan{
    @Override
    protected Employee getEmployee() {
        return new Executive("Dorian", "CEO");
    }
}
