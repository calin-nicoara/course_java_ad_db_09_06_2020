package ro.esolacad.javaad.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ListInvocationHandler implements InvocationHandler {

    private final Object target;

    public ListInvocationHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        System.out.println("This is before invocation");
        System.out.println("Method called: " + method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("This is after invocation");

        return invoke;
    }
}
