package ro.esolacad.javaad.designpatterns.factorymethod;

import org.junit.jupiter.api.Test;

import ro.esolacad.javaad.designpatterns.factorymethod.MonthlyActionPlan;
import ro.esolacad.javaad.designpatterns.factorymethod.MonthlyAssistantActionPlan;
import ro.esolacad.javaad.designpatterns.factorymethod.MonthlyExecutiveActionPlan;

public class FactoryTest {

    @Test
    public void testFActoryMethod() {
        MonthlyActionPlan monthlyActionPlan = new MonthlyAssistantActionPlan();

        monthlyActionPlan.doMonthlyActivities();

        MonthlyActionPlan monthlyActionPlan1 = new MonthlyExecutiveActionPlan();

        monthlyActionPlan1.doMonthlyActivities();
    }
}
