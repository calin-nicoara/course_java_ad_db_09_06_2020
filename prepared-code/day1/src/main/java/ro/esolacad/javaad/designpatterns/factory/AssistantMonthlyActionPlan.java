package ro.esolacad.javaad.designpatterns.factory;

class AssistantMonthlyActionPlan extends MonthlyActionPlan {
    @Override
    protected Employee getEmployee() {
        return new Assistant();
    }
}
