package ro.esolacad.javaad.decorator;

import ro.esolacad.javaad.decorator.Prompter;

public class UpperCasePrompterDecorator extends PrompterDecorator{

    public UpperCasePrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public String giveMyALine() {
        return prompter.giveMyALine().toUpperCase();
    }
}
