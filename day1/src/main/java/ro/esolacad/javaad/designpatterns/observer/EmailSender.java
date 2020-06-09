package ro.esolacad.javaad.designpatterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class EmailSender implements PropertyChangeListener {
    private final List<String> messages = new ArrayList<>();

    public String getNewMessage() {
        if(messages.isEmpty()) {
            return null;
        }

        return "You got an email: " + messages.remove(messages.size()-1);
    }

    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("createFile")) {
            messages.add((String) evt.getNewValue());
        }
    }
}
