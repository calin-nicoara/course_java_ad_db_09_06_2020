package ro.esolacad.javaad.collection;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import ro.esolacad.javaad.oop.User;

public class CollectionUtilTest {

    @Test
    public void testMethods() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(1);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        List<User> users = new ArrayList<>();
        users.add(new User("1", BigDecimal.valueOf(2000)));
        users.add(new User("3", BigDecimal.valueOf(2000)));
        users.add(new User("2", BigDecimal.valueOf(2000)));

        Collections.sort(users, new Comparator<>() {

            @Override
            public int compare(final User o1, final User o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        System.out.println(users);

        Collections.reverse(users);

        System.out.println(users);

    }

    @Test
    public void testEmptyCollections() {
        List<Object> objects = Collections.emptyList();

        List<Integer> numberInteger = new ArrayList<>();
        numberInteger.add(3);
        numberInteger.add(4);

        List<Integer> integers = Collections.unmodifiableList(numberInteger);

        System.out.println(integers);
//        integers.add(3);
    }

    @Test
    public void testArrays() {
        int[] intArray = new int[] {1, 5, 3, 4, 2};

        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        int[] ints = Arrays.copyOf(intArray, 5);

        System.out.println(Arrays.toString(ints));

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers);

        List<Integer> integers1 = List.of(1, 2, 3, 4, 5);
        System.out.println(integers);
    }
}
