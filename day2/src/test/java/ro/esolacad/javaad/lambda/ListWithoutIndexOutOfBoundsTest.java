package ro.esolacad.javaad.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListWithoutIndexOutOfBoundsTest {

    @Test
    public void testListNull() {
        List<Integer> numbers = new ListNoOutOfBounds<>(new ArrayList<>(), index -> null);

        numbers.add(2);
        numbers.add(3);

        assert numbers.get(0) == 2;
        assert numbers.get(1) == 3;

        assert numbers.get(4) == null;
    }

    @Test
    public void testListWithSuppliedValue() {
        List<Integer> numbers = new ListNoOutOfBounds<>(new ArrayList<>(), index -> -1);

        numbers.add(2);
        numbers.add(3);

        assert numbers.get(0) == 2;
        assert numbers.get(1) == 3;

        assert numbers.get(4) == -1;
        assert numbers.size() == 5;
    }

    @Test
    public void testListWithMappedValue() {
        List<Integer> numbers = new ListNoOutOfBounds<>(new ArrayList<>(), index -> index);

        numbers.add(2);
        numbers.add(3);

        assert numbers.get(0) == 2;
        assert numbers.get(1) == 3;

        assert numbers.get(4) == 4;
        assert numbers.size() == 5;
    }

    @Test
    public void testListWithUser() {
        List<User> userList = new ListNoOutOfBounds<>(new ArrayList<>(), index -> {
            final User user = new User();
            user.setId(Long.valueOf(index));
            return user;
        });

        assert userList.get(5).getId() == 5L;
    }
}
