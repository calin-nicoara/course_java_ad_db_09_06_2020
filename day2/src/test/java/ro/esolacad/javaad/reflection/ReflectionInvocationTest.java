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
            Method getPrivateSecretMethod = ReflectionExample.class.getDeclaredMethod("getPrivateSecret");

            String invoke = (String) getPrivateSecretMethod.invoke(reflectionExample);

            assert invoke.equals("secret");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMethodInvocationWithParam() {
        ReflectionExample reflectionExample = new ReflectionExample("INVOKE");

        try {
            Method getPrivateSecretMethod = ReflectionExample.class.getDeclaredMethod("publicMethod",
                    String.class);

            getPrivateSecretMethod.invoke(reflectionExample, "INVOKED!");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNoArgsConstructorInvocation() {

        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor();

            ReflectionExample reflectionExample = constructor.newInstance();

            assert reflectionExample != null;
            reflectionExample.publicMethod();
            assert reflectionExample.getPrivateSecret().equals("noArgs");

        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArgsConstructorInvocation() {

        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor(
                    String.class
            );

            ReflectionExample reflectionExample = constructor.newInstance("withArgs");

            assert reflectionExample != null;
            reflectionExample.publicMethod();
            assert reflectionExample.publicValue.equals("withArgs");

        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
