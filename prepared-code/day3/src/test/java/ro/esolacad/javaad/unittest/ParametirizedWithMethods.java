package ro.esolacad.javaad.unittest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametirizedWithMethods {

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true, LocalDate.now()),
                Arguments.of("", true, null),
                Arguments.of("  ", true, null),
                Arguments.of("not blank", false, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected,
                                                       LocalDate localDate) {
        System.out.println(localDate);
        assertEquals(expected, Strings.isBlank(input));
    }
}
