package ro.esolacad.javaad.designpatterns.decorator;

import java.util.ArrayList;
import java.util.List;

class HistoryPrompter implements Prompter {

    private final List<String> allPrompts = new ArrayList<>();

    @Override
    public void giveYourRegards(final String regards) {
        allPrompts.add(regards);
    }

    @Override
    public String helloThere() {
        return allPrompts.isEmpty() ? null : allPrompts.get(allPrompts.size() - 1);
    }
}
