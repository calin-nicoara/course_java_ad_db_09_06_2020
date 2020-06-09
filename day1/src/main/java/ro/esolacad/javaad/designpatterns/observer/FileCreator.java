package ro.esolacad.javaad.designpatterns.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FileCreator {

    private final PropertyChangeSupport propertyChangeSupport;

    public FileCreator() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void createFile(final String fileContents) {
        // Create file
        propertyChangeSupport.firePropertyChange("createFile", null, fileContents);
    }
}
