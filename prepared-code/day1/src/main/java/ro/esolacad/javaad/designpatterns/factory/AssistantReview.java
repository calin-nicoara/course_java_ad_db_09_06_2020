package ro.esolacad.javaad.designpatterns.factory;

import java.util.Random;

class AssistantReview implements EmployeeReview {
    @Override
    public Integer getScore() {
        return new Random().nextInt();
    }
}
