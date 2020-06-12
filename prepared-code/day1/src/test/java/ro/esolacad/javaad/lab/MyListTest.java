package ro.esolacad.javaad.lab;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyListTest {

    @Test
    public void testFillWithNull() {
        List<Long> list = new ListNoIndexOutOfBoundsDecorator<>(new ArrayList<>(), index -> null);

        list.add(1L);
        list.add(2L);

        assert 2 == list.size();

        assert null == list.get(5);

        assert list.size() == 6;
    }

    @Test
    public void testFillWithSuppliedValue() {
        List<String> list = new ListNoIndexOutOfBoundsDecorator<>(new ArrayList<>(), index -> "Hello");

        list.add("No");
        list.add("Worries");

        assert 2 == list.size();

        assert "Hello".equals(list.get(5));

        assert list.size() == 6;
    }

    @Test
    public void testFillWithIndex() {
        List<Integer> list = new ListNoIndexOutOfBoundsDecorator<>(new LinkedList<>(),
                index -> index);

        list.add(0);
        list.add(1);

        assert 2 == list.size();

        assert 7 == list.get(7);

        assert 8 == list.size();
    }

    @Test
    public void testFillWithFibonacci() {
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> decoratedList = new ListNoIndexOutOfBoundsDecorator<>(list,
                index -> {
                    if (index == 0) {
                        return 0;
                    } else if (index == 1) {
                        return 1;
                    } else {
                        return list.get(index - 1) + list.get(index - 2);
                    }
                });

        assert 0 == decoratedList.get(0);
        assert 1 == decoratedList.get(1);

        assert 2 == decoratedList.size();

        assert 5 == decoratedList.get(5);

        System.out.println(decoratedList.get(20));
    }
}
