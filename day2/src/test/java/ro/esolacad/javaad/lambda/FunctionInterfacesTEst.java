package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfacesTEst {

    @Test
    public void testConsumer() {
        Consumer<String> showMyString = message -> System.out.println(message);

        showMyString.accept("Consumer prompt!");
    }

    @Test
    public void testAndThenConsumer() {
        Consumer<String> showMyString = message -> System.out.println(message);

        Consumer<String> stringConsumer = showMyString.andThen(x -> System.out.println(x.toUpperCase()));
        stringConsumer.accept("hello!");
    }

    @Test
    public void testSupplier() {
        User user = new User(1L, "Gigi", false);

        Supplier<User> userSupplier = () -> new User(1L, "Gigi", false);

        System.out.println("Before use creation");
        System.out.println(userSupplier.get());

        User user1 = userSupplier.get();

        user.setId(2L);

        assert user1.getId() == 1;
    }

    @Test
    public void testFunction() {
        Function<Long, User> userFromIdFunction = id -> new User(id, null, false);

        final User user = userFromIdFunction.apply(4L);

        assert user.getId() == 4L;
    }

    @Test
    public void testPredicate() {
        Predicate<User> employeeIsEmployeed = user -> user.getEmployed();

        User user = new User(1L, null, false);

        assert !employeeIsEmployeed.test(user);
    }

    @Test
    public void testUseLamdasInMethods() {
        User user1 = new User(1L, "Ionut", true);

        final Consumer<User> userConsumer = string -> FunctionalIntefacesTEster.sout(string);
        FunctionalIntefacesTEster.checkForSomethingAndUse(user1,
                user -> user.getEmployed() && user.getName().equals("Ionut"),
                userConsumer);

        User user2 = new User(1L, "Ionut", false);
        FunctionalIntefacesTEster.checkForSomethingAndUse(user2,
                user -> user.getEmployed(), userConsumer);
    }

    @Test
    public void methodREference() {
        ShowMeSomething showMeSomething = FunctionalIntefacesTEster::useStringAndBoolean;

        showMeSomething.showSomething("Hello", true);
    }
}
