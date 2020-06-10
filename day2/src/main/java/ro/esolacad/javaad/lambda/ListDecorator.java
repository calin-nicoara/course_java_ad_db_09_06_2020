package ro.esolacad.javaad.lambda;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ListDecorator<T> implements List<T> {

    private List<T> internalList;

    public ListDecorator(List<T> listToUse) {
        this.internalList = listToUse;
    }


    @Override
    public int size() {
        return internalList.size();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(final T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(final T t) {
        return internalList.add(t);
    }

    @Override
    public boolean remove(final Object o) {
        return internalList.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(final Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(final int i, final Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(final Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(final int i) {
        return internalList.get(i);
    }

    @Override
    public T set(final int i, final T t) {
        return null;
    }

    @Override
    public void add(final int i, final T t) {

    }

    @Override
    public T remove(final int i) {
        return null;
    }

    @Override
    public int indexOf(final Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(final Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(final int i) {
        return null;
    }

    @Override
    public List<T> subList(final int i, final int i1) {
        return null;
    }
}
