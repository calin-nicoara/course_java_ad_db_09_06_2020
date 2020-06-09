package ro.esolacad.javaad.designpatterns.decorator;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ro.esolacad.javaad.decorator.HappyPrompter;
import ro.esolacad.javaad.decorator.HighlightPrompterDecorator;
import ro.esolacad.javaad.decorator.Prompter;
import ro.esolacad.javaad.decorator.UpperCasePrompterDecorator;

public class DecoratorTest {

    @Test
    public void test() {
        new BufferedReader(new InputStreamReader(new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        }));
    }

    @Test
    public void testPrompter() {
        Prompter prompter = new HappyPrompter();
        assert prompter.giveMyALine().equals("It's a beautiful day!");

        Prompter upperCasePrompter = new UpperCasePrompterDecorator(prompter);
        assert upperCasePrompter.giveMyALine().equals("IT'S A BEAUTIFUL DAY!");

        Prompter upperCaseAndHighLightPrompter = new HighlightPrompterDecorator(upperCasePrompter);
        assert upperCaseAndHighLightPrompter.giveMyALine().equals("----- IT'S A BEAUTIFUL DAY! -----");
    }
}
