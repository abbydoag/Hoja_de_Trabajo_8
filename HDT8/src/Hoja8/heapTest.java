package Hoja8;

import java.util.PriorityQueue;
import org.junit.Test;
import static org.junit.Assert.*;

class heapTest {

	@Test
    public void testAddAndRemove() {
		VectorHeap<String> heap = new VectorHeap<String>();
        heap.add("hello");
        heap.add("world");
        assertEquals(2, heap.size());
        assertEquals("hello", heap.poll());
        assertEquals(1, heap.size());
        assertEquals("world", heap.poll());
        assertTrue(heap.isEmpty());
    }
}
