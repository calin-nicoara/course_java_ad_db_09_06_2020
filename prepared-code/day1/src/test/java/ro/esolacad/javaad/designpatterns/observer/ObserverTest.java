package ro.esolacad.javaad.designpatterns.observer;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testFileCreationWithEmailSendingWhenListening() {
        FileCreator fileCreator = new FileCreator();
        EmailSender emailSender = new EmailSender();

        fileCreator.addPropertyChangeListener(emailSender);
        fileCreator.createFile("These are the contents!");

        assert "You got an email: These are the contents!".equals(emailSender.getNewMessage());
    }

    @Test
    public void testFileCreationWithEmailSendingWhenNotListening() {
        FileCreator fileCreator = new FileCreator();
        EmailSender emailSender = new EmailSender();

        fileCreator.createFile("These are the contents!");

        assert null == emailSender.getNewMessage();
    }

    @Test
    public void testFileCreationWithEmailSendingWhenListeningThanNotListening() {
        FileCreator fileCreator = new FileCreator();
        EmailSender emailSender = new EmailSender();

        fileCreator.addPropertyChangeListener(emailSender);
        fileCreator.removePropertyChangeListener(emailSender);
        fileCreator.createFile("These are the contents!");

        assert null == emailSender.getNewMessage();
    }
}
