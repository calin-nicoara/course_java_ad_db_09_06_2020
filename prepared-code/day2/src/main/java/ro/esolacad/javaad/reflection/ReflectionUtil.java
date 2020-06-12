package ro.esolacad.javaad.reflection;

import java.lang.reflect.Method;

public class ReflectionUtil {

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (void.class.equals(method.getReturnType())) return false;
//        if(!Modifier.isPublic(method.getModifiers())) return false;
        if (method.getParameterTypes().length != 0) return false;
        return !method.getName().equals("getClass");
    }
}
