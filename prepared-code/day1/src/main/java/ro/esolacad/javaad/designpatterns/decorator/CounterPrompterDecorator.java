package ro.esolacad.javaad.designpatterns.decorator;

import java.util.concurrent.atomic.AtomicInteger;

class CounterPrompterDecorator extends PrompterDecorator {
    private final AtomicInteger numbers = new AtomicInteger();

    public CounterPrompterDecorator(final Prompter prompter) {
        super(prompter);
    }

    @Override
    public void giveYourRegards(final String regards) {
        numbers.incrementAndGet();
        prompter.giveYourRegards(regards);
    }

    @Override
    public String helloThere() {
        return prompter.helloThere() + " for the " + numbers.get() + " time!";
    }
}
