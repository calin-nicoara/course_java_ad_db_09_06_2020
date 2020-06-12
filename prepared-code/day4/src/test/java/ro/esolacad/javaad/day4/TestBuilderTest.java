package ro.esolacad.javaad.day4;

import org.junit.jupiter.api.Test;

import ro.esolacad.javaad.day4.product.TestBuilder;

public class TestBuilderTest {

    @Test
    public void testBuilder() {
        TestBuilder testBuilder = TestBuilder.builder()
                .name("TestThis")
                .build();

        System.out.println(testBuilder.getName());
    }
}
