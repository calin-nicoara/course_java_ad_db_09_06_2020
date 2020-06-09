package ro.esolacad.javaad.collection;

public class GenericObjectBox<T> {

    private T myObject;

    public void set(final T myObject) {
        this.myObject = myObject;
    }

    public T get() {
        return myObject;
    }
}
