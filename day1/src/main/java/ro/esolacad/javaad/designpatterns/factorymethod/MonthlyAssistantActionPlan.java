package ro.esolacad.javaad.designpatterns.factorymethod;

public class MonthlyAssistantActionPlan extends MonthlyActionPlan{
    @Override
    protected Employee getEmployee() {
        return new Assistant("Ionut", "Asistant Director");
    }
}
