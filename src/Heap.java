import java.util.ArrayList;
import java.util.List;

/**
 * A min-heap. 
 * 
 * Must contain functionality for the following: (n = # of elements in heap)
 * 
 * Adding a new value to the heap  O(log(n))
 * Popping the front of the heap O(log(n))
 * Peeking at the front of the heap without removing the element O(1)
 * Getting the size of the heap O(1)
 * Checking whether the heap is empty O(1)
 * 
 * 
 * The Heap must hold ints
 * 
 * Use List/ArrayList as a backing array, but DO NOT use the 
 * PriorityQueue class. Do not make Node objects, use array
 * indexing instead.
 * 
 * It is up to you to make design decisions about how to:
 *  - name methods
 *  - determine return value and argument types
 *  - hold private instance variables
 */
public class Heap {
    private static List<Integer> heapArray;

    public Heap() {
        heapArray = new ArrayList<>(); // Initialize empty list
        heapArray.add(10);        // Add values sequentially
        heapArray.add(20);
        heapArray.add(30);
    }

    public void printList(){
        System.out.println(heapArray);
    }

    public void addValue(int value) {
        // [10, 20, 30, 5], 5
        // [10, 20, 30, 20], 5
        // [10, 5, 30, 20], 5
        //stops when the position reach index 0 or if the value is larger than parent

        //int i = this.heapArray.length-1;
        // while current position[i] is not index 0 or value is less than parent: keep going
            //int tempValue = position[i];
            //position[i] = position[(i - 1) / 2]
            //position[(i - 1) / 2] = tempValue;
            //i = (i - 1) / 2
        
        heapArray.add(value);
        int i = heapArray.size() - 1;
        while (i != 0 &&  heapArray.get(i) < heapArray.get((i - 1) / 2)) {
            int tempValue = heapArray.get(i);
            heapArray.set(i, heapArray.get((i - 1) / 2));
            heapArray.set((i - 1) / 2, tempValue);
            i = (i - 1) / 2;
        }
    }
    public boolean isEmpty() {
        return heapArray.isEmpty();
    }

    public int pop() {
        return heapArray.remove(heapArray.size() - 1);
    }
}