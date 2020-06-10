package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTerminatingTest {

    @Test
    public void testCollect() {
        Supplier<Stream<Integer>> sorted = () ->Stream.iterate(0, n -> n + 1)
                .limit(1000)
//                .filter(x -> x % 7 == 0)
                .map(x -> x / 7)
//                .peek(x -> System.out.println("From peek" + x))
//                .distinct()
                .skip(10)
                .limit(5)
                .sorted();
        List<Integer> collect = sorted.get()
                .collect(Collectors.toList());

        System.out.println("List: " + collect);

        Set<Integer> set = sorted.get().collect(Collectors.toSet());

        System.out.println("Set: " + set);
    }

    @Test
    public void testUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "Bogdan", true),
                new User(2L, "Bogdan", false),
                new User(3L, "Bogdan", true),
                new User(4L, "Bogdan", true)
        );

        Map<Long, User> collect = users.stream()
                .filter(User::getEmployed)
                .collect(Collectors.toMap(
                        user -> user.getId(), user -> user
                ));

        System.out.println(collect);

        Map<Long, String> collect1 = users.stream()
                .filter(User::getEmployed)
                .collect(Collectors.toMap(
                        user -> user.getId(), user -> user.getName()
                ));

        System.out.println(collect1);
    }

    @Test
    public void testGroupingBy() {
        List<User> users = Arrays.asList(
                new User(1L, "Bogdan", true),
                new User(2L, "Ana", false),
                new User(3L, "Mihaela", true),
                new User(4L, "Codrut", true)
        );

        Map<Boolean, List<User>> collect = users.stream()
                .collect(Collectors.groupingBy(x -> x.getEmployed()));

        System.out.println(collect);

        assert collect.get(true).size() == 3;
        assert collect.get(false).size() == 1;
    }

    @Test
    public void testPartitionBy() {
        List<User> users = Arrays.asList(
                new User(1L, "Bogdan", true),
                new User(2L, "Ana", true),
                new User(3L, "Mihaela", true),
                new User(4L, "Codrut", true)
        );

        Map<Boolean, List<User>> collect = users.stream().collect(Collectors.partitioningBy(x -> x.getEmployed()));

        System.out.println(collect);

        assert collect.get(false).size() == 0;
    }

    @Test
    public void testMatchers() {
        List<User> users = Arrays.asList(
                new User(1L, "Bogdan", true),
                new User(2L, "Ana", true),
                new User(3L, "Mihaela", true),
                new User(4L, "Codrut", true)
        );

        boolean anyMatchAna = users.stream()
                .filter(s -> s.getEmployed())
                .anyMatch(user -> user.getName().equals("Ana"));

        assert anyMatchAna;

        boolean allMAtchIdLessthan10 = users.stream()
                .filter(s -> s.getEmployed())
                .allMatch(s -> s.getId() < 10L);

        assert allMAtchIdLessthan10;

        boolean noneMatchIdMoreThan10 = users.stream()
                .filter(s -> s.getEmployed())
                .noneMatch(s -> s.getId() > 10L);

        assert noneMatchIdMoreThan10;
    }

    @Test
    public void testFind() {

        List<User> users = Arrays.asList(
                new User(1L, "Bogdan", true),
                new User(2L, "Ana", true),
                new User(3L, "Mihaela", true),
                new User(4L, "Codrut", true)
        );

        Optional<User> any = users.stream()
                .filter(s -> s.getId() > 2)
                .findFirst();

        assert any.isPresent();

        System.out.println(any.get());
    }

    @Test
    public void testReduce() {
//        Optional<Integer> reduce = List.of(1, 3, 7, 12)
//                .stream()
//                .reduce((accumulatedValue, currentValue) -> {
//                    System.out.println("Accum: " + accumulatedValue);
//                    System.out.println("Curr: " + currentValue);
//                    return accumulatedValue + currentValue;
//                });
//
//        assert reduce.get() == 23;

        Integer reduce2 = List.of(1, 3, 7, 12)
                .stream()
                .reduce(0, (accumulatedValue, currentValue) -> {
                    System.out.println("Accum: " + accumulatedValue);
                    System.out.println("Curr: " + currentValue);
                    return accumulatedValue + currentValue;
                });

        assert reduce2 == 23;
    }
}
