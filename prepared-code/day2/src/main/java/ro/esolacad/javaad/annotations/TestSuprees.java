package ro.esolacad.javaad.annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestSuprees {

    @SafeVarargs
    static void testSupres(final List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); //
    }

    @SuppressWarnings("unchecked")
    static void unchecked() {
        List words = new ArrayList();

        words.add("hello");
    }
}
