package ro.esolacad.javaad.collection;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ro.esolacad.javaad.oop.User;

public class GenericTest {

    @Test
    public void testWrapperObject() {
        GenericObjectBox<User> genericObjectMapper = new GenericObjectBox<>();

        User user = new User("2", BigDecimal.valueOf(3000));

        genericObjectMapper.set(user);

        assert genericObjectMapper.get() == user;
    }

    @Test
    public void testInheritGeneric() {
        Number number = Integer.valueOf(20);

//        ArrayList<Number> numberList = new ArrayList<Integer>();
    }

    @Test
    public void testWildCard() {
        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);

        List<?> wildCard = list;

        List<? extends Number> numberList = new ArrayList<Short>();

        List<? super Number> numberList2 = new ArrayList<Object>();
    }
}
