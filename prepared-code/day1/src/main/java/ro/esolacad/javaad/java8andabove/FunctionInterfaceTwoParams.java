package ro.esolacad.javaad.java8andabove;

@FunctionalInterface
public interface FunctionInterfaceTwoParams<V, T, W> {

    W concatMe(V first, T second);
}
