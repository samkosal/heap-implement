import static org.junit.Assert.*;
import org.junit.Test;

public class HeapTest {
    @Test
    public void addValue_largerThanRoot_rootUnchanged() {
        Heap heap = new Heap(); // starts as [10, 20, 30]
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.addValue(25);
        assertEquals(10, heap.peek()); // 25 is larger, root stays 10
    }

    @Test
    public void addValue_smallerThanRoot_bubblesUpToRoot() {
        Heap heap = new Heap(); // starts as [10, 20, 30]
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.addValue(5);
        assertEquals(5, heap.peek()); // 5 is smallest, should be new root
    }

    @Test
    public void addValue_increasesSize() {
        Heap heap = new Heap(); // starts with size 3
        heap.addValue(99);
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertEquals(4, heap.size());
    }

    // // ── isEmpty ───────────────────────────────────────────────────────────────

    @Test
    public void isEmpty_newHeap_notEmpty() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void isEmpty_noChanges_returnsTrue() {
        Heap heap = new Heap(); // 3 elements
        
        assertTrue(heap.isEmpty());
    }

    @Test
    public void isEmpty_afterAdd_stillNotEmpty() {
        Heap heap = new Heap();
        heap.addValue(7);
        assertFalse(heap.isEmpty());
    }

    // // ── pop ───────────────────────────────────────────────────────────────────

    @Test
    public void pop_returnsMinimum() {
        Heap heap = new Heap(); // [10, 20, 30]
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertEquals(10, heap.pop());
    }

    @Test
    public void pop_removesElement_sizeDecreases() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.pop();
        assertEquals(2, heap.size());
    }

    @Test
    public void pop_multipleTimesReturnsAscendingOrder() {
        Heap heap = new Heap(); // [10, 20, 30]
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertEquals(10, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(30, heap.pop());
    }

    // // ── peek ──────────────────────────────────────────────────────────────────

    @Test
    public void peek_returnsRoot() {
        Heap heap = new Heap(); // [10, 20, 30]
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertEquals(10, heap.peek());
    }

    @Test
    public void peek_doesNotRemoveElement() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.peek();
        assertEquals(3, heap.size());
    }

    @Test
    public void peek_afterAddSmaller_returnsNewMin() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.addValue(1);
        assertEquals(1, heap.peek());
    }

    // // ── size ──────────────────────────────────────────────────────────────────

    @Test
    public void size_newHeap_returnsThree() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        assertEquals(3, heap.size());
    }

    @Test
    public void size_afterAdd_increments() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.addValue(50);
        assertEquals(4, heap.size());
    }

    @Test
    public void size_afterPop_decrements() {
        Heap heap = new Heap();
        heap.addValue(10);       
        heap.addValue(20);
        heap.addValue(30);
        heap.pop();
        assertEquals(2, heap.size());
    }
}
