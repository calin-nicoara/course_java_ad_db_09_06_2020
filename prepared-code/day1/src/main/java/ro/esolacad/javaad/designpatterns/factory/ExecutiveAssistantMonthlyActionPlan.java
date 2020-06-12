package ro.esolacad.javaad.designpatterns.factory;

class ExecutiveAssistantMonthlyActionPlan extends MonthlyActionPlan{
    @Override
    protected Employee getEmployee() {
        return new ExecutiveEmployee();
    }
}
