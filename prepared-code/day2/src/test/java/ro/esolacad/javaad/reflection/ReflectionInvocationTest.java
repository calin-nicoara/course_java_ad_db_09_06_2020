package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionInvocationTest {

    @Test
    public void testMethodInvocation() {
        ReflectionExample reflectionExample = new ReflectionExample("INVOKE");

        try {
            Method getPublicValue = ReflectionExample.class.getMethod("getPublicValue");

            String publicValue = (String) getPublicValue.invoke(reflectionExample);
            assert publicValue.equals("INVOKE");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNoArgsConstructorInvocation() {
        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor();
            ReflectionExample reflectionExample = constructor.newInstance();

            assert reflectionExample != null;
            assert reflectionExample.getMySecret() == null;

        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArgsConstructorInvocation() {
        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor(String.class);
            ReflectionExample reflectionExample = constructor.newInstance("INSTANCE");

            assert reflectionExample != null;
            assert reflectionExample.getMySecret().equals("secret");
            assert reflectionExample.getPublicValue().equals("INSTANCE");
        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
