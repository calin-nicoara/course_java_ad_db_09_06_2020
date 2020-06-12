package ro.esolacad.javaad.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ExInvocationHandler implements InvocationHandler {

    private final Object target;

    public ExInvocationHandler(final Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

        System.out.println("This is before");
        final Object invoke = method.invoke(target, args);
        System.out.println("This is after");
        return invoke;
    }
}
