package Hoja8;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.Vector;
import java.util.function.Predicate;

public interface PriorityQueue<E> extends Collection<E>{
	boolean add(E e);
    boolean offer(E e);
    E remove();
    E poll();
    E element();
    E peek();
    Object[] toArray();
    <T> T[] toArray(T[] a);
    boolean contains(Object o);
    boolean remove(Object o);
    boolean containsAll(Collection<?> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();
    boolean equals(Object o);
    int hashCode();
    default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(iterator(),size(),0);
    }
}