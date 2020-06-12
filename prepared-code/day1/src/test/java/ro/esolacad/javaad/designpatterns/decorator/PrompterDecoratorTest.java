package ro.esolacad.javaad.designpatterns.decorator;

import org.junit.jupiter.api.Test;

class PrompterDecoratorTest {

    @Test
    public void historyPrompterTest() {
        Prompter prompter = new HistoryPrompter();

        prompter.giveYourRegards("Hello");

        assert prompter.helloThere().equals("Hello");
    }

    @Test
    public void counterDecoratorPrompterTest() {
        Prompter prompter = new CounterPrompterDecorator(new HistoryPrompter());

        prompter.giveYourRegards("Hello");

        assert prompter.helloThere().equals("Hello for the 1 time!");
    }

    @Test
    public void counterDecoratorPrompterTestTwoTimes() {
        Prompter prompter = new CounterPrompterDecorator(new HistoryPrompter());

        prompter.giveYourRegards("Hello");
        prompter.giveYourRegards("Hello again");

        assert prompter.helloThere().equals("Hello again for the 2 time!");
    }

    @Test
    public void randomPrompterDecorator() {
        Prompter prompter = new RandomPrompterDecorator(new CounterPrompterDecorator(new HistoryPrompter()));

        prompter.giveYourRegards("Hello");
        prompter.giveYourRegards("Hello again");

        System.out.println(prompter.helloThere());
        assert prompter.helloThere().equals("---------- HELLO OGOIN FOR THE 2 TIME! ----------");
    }
}
