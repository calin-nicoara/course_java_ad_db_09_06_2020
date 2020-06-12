package ro.esolacad.javaad.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ListDecorator<T> implements List<T> {
    private final List<T> inner;

    public ListDecorator(final List<T> innerList) {
        this.inner = innerList;
    }

    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public boolean isEmpty() {
        return inner.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return inner.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return inner.iterator();
    }

    @Override
    public Object[] toArray() {
        return inner.toArray();
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return inner.toArray(a);
    }

    @Override
    public boolean add(final T t) {
        return inner.add(t);
    }

    @Override
    public boolean remove(final Object o) {
        return inner.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return inner.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        return inner.addAll(c);
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        return inner.addAll(index, c);
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return inner.removeAll(c);
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return inner.retainAll(c);
    }

    @Override
    public void clear() {
        inner.clear();
    }

    @Override
    public T get(final int index) {
        return inner.get(index);
    }

    @Override
    public T set(final int index, final T element) {
        return inner.set(index, element);
    }

    @Override
    public void add(final int index, final T element) {
        inner.add(index, element);
    }

    @Override
    public T remove(final int index) {
        return inner.remove(index);
    }

    @Override
    public int indexOf(final Object o) {
        return inner.indexOf(o);
    }

    @Override
    public int lastIndexOf(final Object o) {
        return inner.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return inner.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return inner.listIterator(index);
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        return inner.subList(fromIndex, toIndex);
    }
}
