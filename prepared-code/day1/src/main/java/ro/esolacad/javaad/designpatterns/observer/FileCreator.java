package ro.esolacad.javaad.designpatterns.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class FileCreator {

    private final PropertyChangeSupport propertyChangeSupport;

    public FileCreator() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }

    public void createFile(final String fileContents) {
        // Created file
        propertyChangeSupport.firePropertyChange("createFile", null, fileContents);
    }
}
