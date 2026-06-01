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
    private List<Integer> heapArray;

    public Heap() {
        heapArray = new ArrayList<>(); // Initialize empty list
        // heapArray.add(10);        // Add values sequentially
        // heapArray.add(20);
        // heapArray.add(30);
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
        // swap the head and last element of list
        // remove the last element
        //sift down
        // the loop stops when the current value is less then both childs or if both childs dont exist
        //

        // [5, 10, 20, 30]
        // [30, 10, 20, 5]
        // [30, 10, 20]
        // [10, 20, 30]

        int Head = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);

        int i = 0;
        // for this loop to run, both child must exist
        while ( 2 * i + 1 < heapArray.size() || 2 * i + 2 < heapArray.size()) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int smallest = i;

            // if left side exist and left side smaller than current smallest index
            if (leftChild < heapArray.size() && heapArray.get(leftChild) < heapArray.get(smallest)) {
                //set the new smallest to left child index
                smallest = leftChild;
            }
            if (rightChild < heapArray.size() && heapArray.get(rightChild) < heapArray.get(smallest)) {
                smallest = rightChild;
            }
            if (smallest == i) break;

            int temp = heapArray.get(i);
            heapArray.set(i, heapArray.get(smallest));
            heapArray.set(smallest, temp);
            i = smallest;
        }

        return Head;
    }

    public int peek() {
        return heapArray.get(0);
    }

    public int size() {
        return heapArray.size();
    }
}