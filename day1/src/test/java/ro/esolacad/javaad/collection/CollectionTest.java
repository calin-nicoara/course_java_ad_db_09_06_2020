package ro.esolacad.javaad.collection;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import ro.esolacad.javaad.oop.User;

public class CollectionTest {

    @Test
    public void testArray() {
        int[] intArray = new int[3];
        int[] intArray2 = new int[] {1, 2, 3};
    }

    @Test
    public void testList() {
        List<Integer> integers = new ArrayList<>();

        integers.add(2);
        integers.add(3);
        integers.add(3);

        assert integers.get(0) == 2;
        assert integers.get(1) == 3;
        assert integers.get(2) == 3;

        assert integers.remove(Integer.valueOf(2));
    }

    @Test
    public void testSet() {
        Set<Integer> integers = new HashSet<>();

        integers.add(2);
        integers.add(2);
        integers.add(3);

        for(Integer element: integers) {
            System.out.println(element);
        }
    }

    @Test
    public void testUserCollections() {
        Set<User> userSet = new HashSet<>();

        userSet.add(new User("1", BigDecimal.valueOf(2000)));
        userSet.add(new User("2", BigDecimal.valueOf(3000)));
        User user = new User("3", BigDecimal.valueOf(4000));

        userSet.add(user);
        userSet.add(user);

        for(User useritem: userSet) {
            System.out.println(useritem);
        }

        user.setId("4");
        userSet.add(user);

        System.out.println();
        for(User useritem: userSet) {
            System.out.println(useritem);
        }
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = BigDecimal.valueOf(100.03);

        System.out.println(bigDecimal.toBigInteger());
    }

    @Test
    public void testGeneric() {
        List<Integer> list = new ArrayList<>();

        list.add(3);

        Integer o = list.get(0);
    }

    @Test
    public void testMap() {
        Map<String, User> userMap = new HashMap<>();

        userMap.put("1", new User("1", BigDecimal.valueOf(2000)));
        userMap.put("2", new User("2", BigDecimal.valueOf(3000)));
        userMap.put("3", new User("3", BigDecimal.valueOf(4000)));

        assert userMap.size() == 3;

        assert userMap.get("1").equals(new User("1", BigDecimal.valueOf(2000)));

        userMap.put("3", null);
        assert userMap.get("3") == null;

        userMap.put(null, new User(null, BigDecimal.valueOf(0)));

        assert userMap.get(null).equals(new User(null, BigDecimal.valueOf(0)));
    }

    @Test
    public void tesTList2() {
        List<Integer> list = new ArrayList<>();

//        list.get(0);

        assert list.get(5) == 5;

        List<String> list2 = new ArrayList<>();
        assert list.get(5).equals("Item number 5");
    }
}
