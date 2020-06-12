package ro.esolacad.javaad.designpatterns.factory;

import org.junit.jupiter.api.Test;

public class MonthlyActionPlanTest {

    @Test
    public void testAssistantActionPlan() {
        MonthlyActionPlan assistantMonthlyActionPlan = new AssistantMonthlyActionPlan();

        assistantMonthlyActionPlan.doMonthlyActivities();
    }

    @Test
    public void testExecutiveActionPlan() {
        MonthlyActionPlan monthlyActionPlan = new ExecutiveAssistantMonthlyActionPlan();

        monthlyActionPlan.doMonthlyActivities();
    }
}
