package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionExampleTest {

    @Test
    public void testClass() {
        Object reflectionExample = new ReflectionExample("New reflection");

        Class<?> aClass = reflectionExample.getClass();

        assert aClass.equals(ReflectionExample.class);

        assert aClass.getName().equals("ro.esolacad.javaad.reflection.ReflectionExample");
        assert aClass.getSimpleName().equals("ReflectionExample");
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] constructors = ReflectionExample.class.getConstructors();

        assert constructors.length == 2;

        Optional<Constructor<?>> any = Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterCount() == 1)
                .findAny();

        Class<?>[] parameterTypes = any.get().getParameterTypes();

        assert parameterTypes[0] == String.class;
    }

    @Test
    public void testGetConstructor() {
        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor(String.class);
            assert constructor != null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMethods() {
        Method[] methods = ReflectionExample.class.getMethods();

        for(Method method: methods) {
            System.out.println(method.getName());
        }

        Method[] declaredMethods = ReflectionExample.class.getDeclaredMethods();

        System.out.println();
        for(Method method: declaredMethods) {
            System.out.println(method.getName());
        }
    }

    @Test
    public void testGetFields() {
        Field[] fields = ReflectionExample.class.getFields();
        for(Field field: fields) {
            System.out.println(field.getName());
        }

        System.out.println();
        for(Field field: ReflectionExample.class.getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
