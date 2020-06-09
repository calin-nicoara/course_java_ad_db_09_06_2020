package ro.esolacad.javaad.decorator;

import ro.esolacad.javaad.decorator.Prompter;

public class HighlightPrompterDecorator extends PrompterDecorator{

    public HighlightPrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public String giveMyALine() {
        return "----- " + prompter.giveMyALine() + " -----";
    }
}
