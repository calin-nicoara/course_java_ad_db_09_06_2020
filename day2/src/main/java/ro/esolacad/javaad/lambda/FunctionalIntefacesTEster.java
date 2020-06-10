package ro.esolacad.javaad.lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalIntefacesTEster {

    public static void checkForSomethingAndUse(
            User user,
            Predicate<User> check, Consumer<User> doAction) {
        if(check.test(user)) {
            doAction.accept(user);
        }
    }

    public static void sout(User string){
        System.out.println(string);
    }

    public static void useStringAndBoolean(String string, boolean flag) {
        System.out.println(string + " " + flag);
    }
}
