package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GetterTest {

    @Test
    public void testIsGetter() {
        System.out.println("Getters");
        Arrays
                .asList(ExampleBean.class.getMethods())
                .stream()
                .filter(s -> ReflectionUtil.isGetter(s))
                .forEach(s -> System.out.println(s.getName()));
    }
}
