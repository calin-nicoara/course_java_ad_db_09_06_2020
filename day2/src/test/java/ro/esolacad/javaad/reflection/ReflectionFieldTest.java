package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionFieldTest {

    @Test
    public void testGetFieldValue() {
        ReflectionExample reflectionExample = new ReflectionExample("Hello!");

        try {
            Field publicValue = ReflectionExample.class.getField("publicValue");
            assert publicValue.get(reflectionExample).equals("Hello!");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void testGetPrivateFieldValue() {
        ReflectionExample reflectionExample = new ReflectionExample("Hello!");

        try {
            Field privateSecretField = ReflectionExample.class.getDeclaredField("privateSecret");
            privateSecretField.setAccessible(true);
            assert privateSecretField.get(reflectionExample).equals("secret");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void testSetField() {
        ReflectionExample reflectionExample = new ReflectionExample("Hello!");

        try {
            Field privateSecretField = ReflectionExample.class.getField("publicValue");
            privateSecretField.set(reflectionExample, "New Hello!");

            assert reflectionExample.publicValue.equals("New Hello!");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void testStaticField() {
        try {
            Field staticField = ReflectionExample.class.getField("MESSAGE");

            assert staticField.get(null).equals("STATIC");
//            staticField.setAccessible(true);
//            staticField.set(null, "New Hello!");
//
//            assert reflectionExample.publicValue.equals("New Hello!");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
