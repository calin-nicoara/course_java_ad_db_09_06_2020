package ro.esolacad.javaad.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionsTest {

    @Test
    public void testLists() {
        List<Long> list = new ArrayList<>();

        list.add(1L);
        list.add(2L);

        assert list.size() == 2;

        assert list.get(0) == 1L;
        assert list.get(1) == 2L;
    }

    @Test
    public void testSets() {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(2L);
        set.remove(3);

        assert set.size() == 2;

        set.clear();

        assert set.size() == 0;
    }

    @Test
    public void testQueue() {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(2L);

        assert queue.peek() == 2L;


        queue.poll();

        queue.add(1L);
        queue.element();
        queue.remove();
    }

    @Test
    public void testMap() {
        Map<String, Long> map = new HashMap<>();
        map.put("one", 1L);
        map.put("two", 2L);

        assert map.get("two") == 2L;

        map.put("two", 22L);

        assert map.get("two") == 22L;

        assert map.size() == 2;

        map.clear();
        assert map.size() == 0;
    }

    @Test
    public void testSync() {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(1L);

        assert list.get(0) == 2L;

        Collections.sort(list);

        assert list.get(0) == 1L;
    }

    @Test
    public void testArrays() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        assert integers.size() == 4;
    }
}
