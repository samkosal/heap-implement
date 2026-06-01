I am a Java student learning about heaps and wanting to practice good OOP. WITHOUT JUST REWRITING THE CODE FOR ME, please let me know what parts of this are and are not idiomatic, and help me spot any bugs:


## AI response:
Here's a review organized by category:

Bugs
pop() — wrong while condition comment
The comment says "for this loop to run, both child must exist" but you wrote ||. Your code actually says "at least one child" — which is the correct logic. The comment is the lie, not the code. Worth fixing so future-you isn't confused.

peek() and pop() — no empty-heap protection
If called on an empty heap, both will throw IndexOutOfBoundsException with a confusing message. Idiomatic Java would throw NoSuchElementException (what PriorityQueue itself does) with a helpful message. Think: where should that guard live — in the method, or only in the caller?

Non-Idiomatic (Heap.java)
int Head — Java convention is camelCase for all local variables. Head looks like a class name. Should be head or min.

printList() — In OOP, the idiomatic way to give an object a string representation is to override toString(). Then callers can do System.out.println(heap) naturally.

addValue — The word "Value" is redundant context. Java's own PriorityQueue just calls it add(). Shorter and consistent with the Collections API.

heapArray — The name says "array" but it's a List. This is misleading. Common names for this field are data, elements, or just heap.

Stale pseudocode comments in addValue — Those draft notes served you well while writing the code, but they're noise now that the real code is there.

Non-Idiomatic (HeapTest.java)
JUnit 4 imports on a JUnit 5 jar — Your lib has junit-platform-console-standalone (JUnit 5), but your imports are org.junit.Test / org.junit.Assert (JUnit 4). This is the likely reason the beaker isn't working. The JUnit 5 equivalents are in org.junit.jupiter.api.

isEmpty_noChanges_returnsTrue comment — Says "// 3 elements" but the constructor now creates an empty heap. Outdated comments in tests are dangerous — they become the wrong specification.

Duplicate setup repeated across every test — Every test manually calls addValue(10), addValue(20), addValue(30). JUnit provides @BeforeEach for exactly this — a setup method that runs before each test. It removes the repetition and makes the intent of each test clearer.