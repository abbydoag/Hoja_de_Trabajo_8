package Hoja8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.Predicate;

public class VectorHeap<E extends Comparable<E>>implements PriorityQueue<E>, Collection<E>{
	 private ArrayList<E> heap;

	    public VectorHeap() {
	        heap = new ArrayList<E>();
	    }

	    public VectorHeap(ArrayList<E> v) {
	        heap = new ArrayList<E>(v);
	        for (int i = heap.size()/2-1;i>=0;i--)
	            downheap(i);
	    }

	    private void downheap(int root) {
	        E value = heap.get(root);
	        while (root < heap.size() / 2) {
	            int childpos = 2 * root + 1;
	            if (childpos < heap.size() - 1 && heap.get(childpos + 1).compareTo(heap.get(childpos)) < 0)
	                childpos++;
	            if (heap.get(childpos).compareTo(value)>=0)
	                break;
	            heap.set(root,heap.get(childpos));
	            root = childpos;
	        }
	        heap.set(root, value);
	    }

	    private void upheap(int leaf) {
	        E value = heap.get(leaf);
	        while (leaf>0 && value.compareTo(heap.get((leaf-1)/2))<0) {
	            int parent = (leaf - 1) / 2;
	            heap.set(leaf, heap.get(parent));
	            leaf = parent;
	        }
	        heap.set(leaf, value);
	    }

	    @Override
	    public boolean add(E value) {
	        heap.add(value);
	        upheap(heap.size()-1);
			return true;
	    }

	    @Override
	    public E remove() {
	        if (heap.isEmpty())
	            return null;
	        E root = heap.get(0);
	        heap.set(0, heap.get(heap.size()-1));
	        heap.remove(heap.size()-1);
	        downheap(0);
	        return root;
	    }

	    @Override
	    public E peek() {
	        return heap.isEmpty() ? null:heap.get(0);
	    }

	    @Override
	    public boolean isEmpty() {
	        return heap.isEmpty();
	    }

	    @Override
	    public int size() {
	        return heap.size();
	    }

	    @Override
	    public void clear() {
	        heap.clear();
	    }
	    @Override
	    public boolean offer(E e) {
	        return add(e);
	    }
	    @Override
	    public boolean contains(Object o) {
	        return heap.contains(o);
	    }

	    @Override
	    public boolean containsAll(Collection<?> c) {
	        return heap.containsAll(c);
	    }

	    @Override
	    public Iterator<E> iterator() {
	        return heap.iterator();
	    }

	    @Override
	    public boolean remove(Object o) {
	        return heap.remove(o);
	    }

	    @Override
	    public boolean removeAll(Collection<?> c) {
	        return heap.removeAll(c);
	    }

	    @Override
	    public boolean retainAll(Collection<?> c) {
	        return heap.retainAll(c);
	    }

	    @Override
	    public Object[] toArray() {
	        return heap.toArray();
	    }

	    @Override
	    public <T> T[] toArray(T[] a) {
	        return heap.toArray(a);
	    }
	    
	    public boolean addAll(Collection<? extends E> c) {
	        boolean modified = false;
	        for (E element : c) {
	            if (add(element)) {
	                modified = true;
	            }
	        }
	        return modified;
	    }
	    
		@Override
		public boolean removeIf(Predicate<? super E> filter) {
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
///
		@Override
		public boolean addAll(Hoja8.Collection<? extends E> c) {
		    boolean modified = false;
		    for (E element : c) {
		        if (add(element)) {
		            modified = true;
		        }
		    }
		    return modified;
		}

		@Override
		public E poll() {
		    if (heap.isEmpty())
		        return null;
		    E root = heap.get(0);
		    heap.set(0, heap.get(heap.size()-1));
		    heap.remove(heap.size()-1);
		    downheap(0);
		    return root;
		}

		@Override
		public E element() {
		    if (heap.isEmpty())
		        throw new NoSuchElementException();
		    return heap.get(0);
		}

		@Override
		public boolean containsAll(Hoja8.Collection<?> c) {
		    return heap.containsAll((Collection<?>) c);
		}

		@Override
		public boolean removeAll(Hoja8.Collection<?> c) {
		    return heap.removeAll((Collection<?>) c);
		}

		@Override
		public boolean retainAll(Hoja8.Collection<?> c) {
		    return heap.retainAll((Collection<?>) c);
		}

		@Override
		public Spliterator<E> spliterator() {
		    return heap.spliterator();
		}	
		
}