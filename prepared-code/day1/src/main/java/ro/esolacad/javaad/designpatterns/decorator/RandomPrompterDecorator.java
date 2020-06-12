package ro.esolacad.javaad.designpatterns.decorator;

class RandomPrompterDecorator extends PrompterDecorator {
    public RandomPrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void giveYourRegards(final String regards) {
        String newRegards = regards.replace("a", "o");
        prompter.giveYourRegards(newRegards);
    }

    @Override
    public String helloThere() {
        return "---------- " + prompter.helloThere().toUpperCase() + " ----------";
    }
}
