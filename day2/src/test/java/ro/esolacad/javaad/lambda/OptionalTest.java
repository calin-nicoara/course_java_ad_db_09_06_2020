package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional() {
        OptionalTester optionalTester = new OptionalTester();

        assert !optionalTester.getUser(1L).isEmpty();

        Optional<User> optionalTesterNotEmpty = optionalTester.getUser(1L);

//        assert optionalTesterEmpty.isEmpty();

//        if(!optionalTesterEmpty.isEmpty()) {
//            User user = optionalTesterEmpty.get();
//            System.out.println(user);
//        }

        optionalTesterNotEmpty.ifPresent(user -> System.out.println(user));
    }

    @Test
    public void testOptionalEmpty() {
        OptionalTester optionalTester = new OptionalTester();

        assert !optionalTester.getUser(1L).isEmpty();

        Optional<User> optionalTesterEmpty = optionalTester.getUser(1L);
        User user = optionalTesterEmpty.orElse(new User(4L, "Bogdan", false));

        assert user.getId() == 1L;

        Optional<User> optionalTesterEmpty2 = optionalTester.getUser(100L);
        User user2 = optionalTesterEmpty.orElseGet(() -> new User(4L, "Bogdan", false));

        assert user2.getId() == 1L;

        Optional<String> stringOptional = Optional.empty();

        assert stringOptional.orElse("test").equals("test");

        Optional<User> userOptional = Optional.of(new User());
    }
}
