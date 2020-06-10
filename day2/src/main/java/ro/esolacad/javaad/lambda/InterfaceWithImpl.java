package ro.esolacad.javaad.lambda;

public interface InterfaceWithImpl {

    default void saySomething() {
        say();
    }

    private void say() {
        System.out.println("hello");
    }
}
