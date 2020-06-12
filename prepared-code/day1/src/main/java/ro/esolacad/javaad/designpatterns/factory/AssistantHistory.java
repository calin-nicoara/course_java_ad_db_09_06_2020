package ro.esolacad.javaad.designpatterns.factory;

import java.util.List;

class AssistantHistory implements EmployeeHistory {
    @Override
    public List<String> getFormerEmployees() {
        return List.of("New Vision", "Computers are Us!");
    }
}
