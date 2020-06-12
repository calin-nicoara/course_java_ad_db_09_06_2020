package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ReflectionInheritanceTest {

    @Test
    public void testSuperClass() {
        ChildReflectionExample childReflectionExample = new ChildReflectionExample("Child");

        Method[] methods = ChildReflectionExample.class.getMethods();

        for (final Method method : methods) {
            System.out.println(method.getDeclaringClass().getSimpleName() + " " + method.getName());
        }

        assert ChildReflectionExample.class.getSuperclass().getSimpleName().equals("ReflectionExample");
    }

    @Test
    public void testImplementedInterface() {
        Class<?>[] interfaces = ChildReflectionExample.class.getInterfaces();

        assert interfaces.length == 1;
        assert interfaces[0].getSimpleName().equals("Shoutout");

        Class<?> anInterface = interfaces[0];

        assert anInterface.getSuperclass() == null;
    }
}
