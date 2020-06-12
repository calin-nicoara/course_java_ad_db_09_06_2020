package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionFieldTest {

    @Test
    public void testGetFieldValue() {
        ReflectionExample reflectionExample = new ReflectionExample("HELLO!");

        try {
            Field publicValue = ReflectionExample.class.getField("publicValue");
            assert publicValue.get(reflectionExample).equals("HELLO!");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            assert false;
        }
    }

    @Test
    public void testGetPrivateFieldValue() {
        ReflectionExample reflectionExample = new ReflectionExample("HELLO!");

        try {
            Field publicValue = ReflectionExample.class.getDeclaredField("privateSecret");
            publicValue.setAccessible(true);
            assert publicValue.get(reflectionExample).equals("secret");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            assert false;
        }
    }

    @Test
    public void testSetField() {
        ReflectionExample reflectionExample = new ReflectionExample("HELLO!");

        try {
            Field publicValue = ReflectionExample.class.getField("publicValue");

            publicValue.set(reflectionExample, "BYE!");

            assert reflectionExample.publicValue.equals("BYE!");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStaticField() {
        try {
            Field publicValue = ReflectionExample.class.getField("MESSAGE");
            assert publicValue.get(null).equals("STATIC");

//            publicValue.set(null, "DYNAMIC");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
