package ro.esolacad.javaad.lambda;

import java.util.List;
import java.util.function.Function;

public class ListNoOutOfBounds<T> extends ListDecorator<T>{

    private final Function<Integer, T> function;

    public ListNoOutOfBounds(final List<T> listToUse, final Function<Integer, T> supplier) {
        super(listToUse);
        this.function = supplier;
    }

    @Override
    public T get(final int index) {
        while(index >= size()) {
            add(function.apply(size()));
        }

        return super.get(index);
    }
}
