package ro.esolacad.javaad.lab;

import java.util.List;
import java.util.function.Function;

public class ListNoIndexOutOfBoundsDecorator<T> extends ListDecorator<T> {

    private final Function<Integer, T> valueFunction;

    public ListNoIndexOutOfBoundsDecorator(final List<T> innerList,
                                           final Function<Integer, T> valueFunction) {
        super(innerList);
        this.valueFunction = valueFunction;
    }

    @Override
    public T get(final int index) {
        while (index >= size()) {
            add(this.valueFunction.apply(size()));
        }

        return super.get(index);
    }
}
