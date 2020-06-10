package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionAdditionalTest {

    @Test
    public void testSuperClass() {
        Class<ChildReflectionExample> childReflectionExampleClass = ChildReflectionExample.class;

        Class<? super ChildReflectionExample> superclass = childReflectionExampleClass.getSuperclass();

        assert superclass.equals(ReflectionExample.class);
    }

    @Test
    public void testModifiers() throws Exception{
        Class<ReflectionExample> reflectionExampleClass = ReflectionExample.class;

        Field messageField = reflectionExampleClass.getField("MESSAGE");

        assert Modifier.isStatic(messageField.getModifiers());
        assert Modifier.isPublic(messageField.getModifiers());
        assert !Modifier.isVolatile(messageField.getModifiers());
    }

    @Test
    public void testPackage() {
        Package aPackage = ReflectionExample.class.getPackage();

        System.out.println(aPackage.getName());
    }

    @Test
    public void testAnnotation() throws Exception{
        ReflectionExample reflectionExample = new ReflectionExample();
        String privateSecret = getPrivateSecret(reflectionExample);

        assert privateSecret.equals("noArgs");
    }

    private String getPrivateSecret(final ReflectionExample reflectionExample) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method getPrivateSecret = ReflectionExample.class.getDeclaredMethod("getPrivateSecret");

        ShouldUpperCase annotation = getPrivateSecret.getAnnotation(ShouldUpperCase.class);

        String result = (String) getPrivateSecret.invoke(reflectionExample);
        if(annotation != null) {

            return annotation.value() ? result.toUpperCase() : result;
        }

        return result;
    }
}
