package ro.esolacad.javaad.unittest;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import ro.esolacad.javaad.cleancode.immutable.ImmutableCitizen;

import static org.junit.jupiter.api.Assertions.*;

public class JUnitExamples {

    @Test
    public void testAssertEquals() {

        List<Integer> actualList = List.of(1, 2, 3, 4, 5);
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5);

//        assert actualList.equals(expectedList);

        assertEquals(expectedList, actualList);

        assertNotEquals(List.of(1, 2), actualList);

        assertNotSame(actualList, expectedList);

        final ImmutableCitizen citizenExpected = new ImmutableCitizen(
                1L, "bobo", LocalDate.now(), "Romanian", false
        );

        final ImmutableCitizen citizenActual = new ImmutableCitizen(
                2L, "bobo", LocalDate.now(), "Romanian", false
        );

        assertNotEquals(citizenExpected,citizenActual);
    }

    @Test
    @Disabled
    public void testLists() {
        List<Integer> actualList = List.of(1, 2, 3, 4, 5);
        List<Integer> expectedList = List.of(1, 2, 3, 4, 5);

        assertIterableEquals(expectedList, actualList);

        List<String> strings = Arrays.asList("Hello", "there");
        List<String> strings2 = Arrays.asList("Hello", "there");

        assertLinesMatch(strings, strings2);
    }

    @Test
    public void testAssertAll() {
        final ImmutableCitizen citizenExpected = new ImmutableCitizen(
                1L, "bobo", LocalDate.now(), "Romanian", false
        );

        assertAll("getter",
                () -> assertEquals(citizenExpected.getIdNumber(), 1L),
                () -> assertEquals(citizenExpected.getName(), "bobo")
        );
    }

    @Test
    public void testAssumption() {
        final ImmutableCitizen citizenExpected = new ImmutableCitizen(
                1L, "bobo", LocalDate.now(), "Romanian", false
        );

        Assumptions.assumeTrue(citizenExpected.getIdNumber() == 2L);

        fail();
    }
}
