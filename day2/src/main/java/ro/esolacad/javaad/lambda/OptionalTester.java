package ro.esolacad.javaad.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTester {

    Map<Long, User> users = new HashMap<>();

    public OptionalTester() {
        users.put(1L, new User(1L ,"Ionut", true));
        users.put(2L, new User(2L ,"Ionut", true));
        users.put(3L, new User(3L ,"Ionut", true));
    }

    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(users.get(id));
    }
}
