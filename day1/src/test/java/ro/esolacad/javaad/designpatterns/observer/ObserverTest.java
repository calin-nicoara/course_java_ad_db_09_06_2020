package ro.esolacad.javaad.designpatterns.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    public void testFileCreationAndEmailSending() {
        FileCreator fileCreator = new FileCreator();
        EmailSender emailSender = new EmailSender();
        EmailSender emailSenderNotListening = new EmailSender();

        assert emailSender.getNewMessage() == null;
        assert emailSenderNotListening.getNewMessage() == null;

        fileCreator.addChangeListener(emailSender);
        fileCreator.createFile("There are the contents!");

        assert emailSender.getNewMessage().equals("You got an email: There are the contents!");
        assert emailSenderNotListening.getNewMessage() == null;
    }

}
