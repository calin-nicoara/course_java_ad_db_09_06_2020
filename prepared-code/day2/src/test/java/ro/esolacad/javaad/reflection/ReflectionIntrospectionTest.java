package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionIntrospectionTest {

    @Test
    public void testClass() {

        ReflectionExample reflectionExample = new ReflectionExample("New reflection");

        Class<? extends ReflectionExample> aClass = reflectionExample.getClass();

        assert aClass.equals(ReflectionExample.class);

        assert aClass.getName().equals("ro.esolacad.javaad.reflection.ReflectionExample");
        assert aClass.getSimpleName().equals("ReflectionExample");
    }

    @Test
    public void testConstructors() {
        Constructor<?>[] constructors = ReflectionExample.class.getConstructors();

        assert constructors.length == 2;

        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];

            if (constructor.getParameterCount() == 1) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                assert parameterTypes[0] == String.class;
            }
        }
    }

    @Test
    public void testGetConstructor() {
        try {
            Constructor<ReflectionExample> constructor = ReflectionExample.class.getConstructor(String.class);
            assert constructor != null;
        } catch (NoSuchMethodException e) {
            assert false;
        }
        try {
            ReflectionExample.class.getConstructor(Integer.class);
            assert false;
        } catch (NoSuchMethodException e) {
            assert true;
        }
    }

    @Test
    public void testGetMethods() {
        Method[] methods = ReflectionExample.class.getMethods();

        for (final Method method : methods) {
            System.out.println(method.getName());
        }

        assert methods.length == 14;

        assert ReflectionExample.class.getDeclaredMethods().length == 6;
    }

    @Test
    public void testGetFields() {
        Field[] fields = ReflectionExample.class.getFields();
        for (final Field field : fields) {
            System.out.println(field.getName());
        }

        assert fields.length == 2;
        assert ReflectionExample.class.getDeclaredFields().length == 3;
    }

    @Test
    public void testPackage() {
        Package aPackage = ReflectionExample.class.getPackage();

        assert aPackage.getName().equals("ro.esolacad.javaad.reflection");
    }

    @Test
    public void testAnnotation() {
        try {
            Field nicknameField = ChildReflectionExample.class.getField("nickname");

            AnnotationForReflection annotation = nicknameField.getAnnotation(AnnotationForReflection.class);

            assert annotation.isSpecial();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testModifiers() throws Exception {
        Class<ReflectionExample> reflectionExampleClass = ReflectionExample.class;

        Field messageField = reflectionExampleClass.getField("MESSAGE");
        Method privateMethod = reflectionExampleClass.getDeclaredMethod("privateMethod");

        assert Modifier.isPublic(reflectionExampleClass.getModifiers());
        assert Modifier.isStatic(messageField.getModifiers());
        assert Modifier.isPrivate(privateMethod.getModifiers());
    }
}
