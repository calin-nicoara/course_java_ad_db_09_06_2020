package ro.esolacad.javaad.decorator;

public class HappyPrompter implements Prompter {

    @Override
    public String giveMyALine() {
        return "It's a beautiful day!";
    }
}
