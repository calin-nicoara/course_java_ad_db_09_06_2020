package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {

    @Test
    public void testListProxy() {
        List<String> listToProxy = new ArrayList<>();
        listToProxy.add("First");
        listToProxy.add("Second");
        listToProxy.add("Third");

        List proxyedList = (List) Proxy.newProxyInstance(List.class.getClassLoader(),
                new Class[]{List.class},
                new ListInvocationHandler(listToProxy));

        proxyedList.add("Fourth");

        System.out.println(proxyedList);
    }
}
