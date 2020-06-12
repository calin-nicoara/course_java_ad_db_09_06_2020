package ro.esolacad.javaad.designpatterns.decorator;

abstract class PrompterDecorator implements Prompter {
    protected Prompter prompter;

    public PrompterDecorator(Prompter prompter) {
        this.prompter = prompter;
    }
}
