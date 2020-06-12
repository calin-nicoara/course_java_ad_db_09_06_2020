package ro.esolacad.javaad.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {

    @Test
    public void testListProxy() {
        List<String> listToProxy = new ArrayList<>();
        listToProxy.add("1");
        listToProxy.add("2");
        listToProxy.add("3");

        final List o = (List) Proxy.newProxyInstance(
                List.class.getClassLoader(),
                new Class[]{List.class},
                new ExInvocationHandler(listToProxy));

        o.add("2");

        System.out.println(o);
    }

    @Test
    public void testShoutProxy() {
        FriendlyHuman friendlyHuman = new FriendlyHuman();

        final Shoutout o1 = (Shoutout) Proxy.newProxyInstance(
                Shoutout.class.getClassLoader(),
                new Class[]{Shoutout.class},
                new ExInvocationHandler(friendlyHuman));

        o1.shoutout();
    }
}
