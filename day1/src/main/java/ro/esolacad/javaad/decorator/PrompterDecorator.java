package ro.esolacad.javaad.decorator;

public abstract class PrompterDecorator implements Prompter {
    protected Prompter prompter;

    public PrompterDecorator(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public String giveMyALine() {
        return prompter.giveMyALine();
    }
}
