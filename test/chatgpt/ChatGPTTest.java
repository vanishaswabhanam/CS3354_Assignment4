

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * ChatGPT-generated unit tests for Stack class.
 * These tests aim for comprehensive coverage including edge cases,
 * boundary conditions, and exception handling.
 *
 * Generated using prompt: "Generate comprehensive JUnit test cases for a Stack
 * implementation that test all methods including edge cases, boundary conditions,
 * exception scenarios, and normal operations."
 */
public class ChatGPTTest {

    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack(5);
    }

    // Constructor Tests
    @Test
    public void testConstructorCreatesEmptyStack() {
        Stack s = new Stack(10);
        assertTrue("Newly created stack should be empty", s.isEmpty());
        assertEquals("Newly created stack should have size 0", 0, s.size());
    }

    @Test
    public void testConstructorWithSizeOne() {
        Stack s = new Stack(1);
        assertTrue("Stack of size 1 should be empty initially", s.isEmpty());
        assertFalse("Stack of size 1 should not be full initially", s.isFull());
    }

    // Push Method Tests
    @Test
    public void testPushSingleElement() {
        stack.push(10);
        assertEquals("Size should be 1 after pushing one element", 1, stack.size());
        assertFalse("Stack should not be empty after push", stack.isEmpty());
    }

    @Test
    public void testPushMultipleElements() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals("Size should be 3 after pushing three elements", 3, stack.size());
        assertEquals("Top element should be 30", 30, stack.peek());
    }

    @Test
    public void testPushToCapacity() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertTrue("Stack should be full after pushing to capacity", stack.isFull());
        assertEquals("Size should equal capacity", 5, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPushToFullStack() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.push(100); // Should throw exception
    }

    @Test(expected = IllegalStateException.class)
    public void testPushBeyondCapacity() {
        Stack smallStack = new Stack(1);
        smallStack.push(1);
        smallStack.push(2); // Should throw exception
    }

    // Pop Method Tests
    @Test
    public void testPopSingleElement() {
        stack.push(42);
        int popped = stack.pop();
        assertEquals("Popped element should be 42", 42, popped);
        assertTrue("Stack should be empty after popping last element", stack.isEmpty());
    }

    @Test
    public void testPopMultipleElements() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals("First pop should return 30", 30, stack.pop());
        assertEquals("Second pop should return 20", 20, stack.pop());
        assertEquals("Third pop should return 10", 10, stack.pop());
        assertTrue("Stack should be empty after all pops", stack.isEmpty());
    }

    @Test
    public void testPopLIFOOrder() {
        int[] values = {1, 2, 3, 4, 5};
        for (int val : values) {
            stack.push(val);
        }

        for (int i = values.length - 1; i >= 0; i--) {
            assertEquals("Elements should be popped in LIFO order", values[i], stack.pop());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testPopFromEmptyStack() {
        stack.pop(); // Should throw exception
    }

    @Test(expected = IllegalStateException.class)
    public void testPopFromNewStack() {
        Stack newStack = new Stack(10);
        newStack.pop(); // Should throw exception
    }

    // Peek Method Tests
    @Test
    public void testPeekSingleElement() {
        stack.push(99);
        assertEquals("Peek should return 99", 99, stack.peek());
        assertEquals("Size should remain 1 after peek", 1, stack.size());
    }

    @Test
    public void testPeekDoesNotRemoveElement() {
        stack.push(50);
        int firstPeek = stack.peek();
        int secondPeek = stack.peek();
        assertEquals("Multiple peeks should return same value", firstPeek, secondPeek);
        assertEquals("Size should remain unchanged after peeks", 1, stack.size());
    }

    @Test
    public void testPeekAfterMultiplePushes() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals("Peek should return last pushed element", 30, stack.peek());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyStack() {
        stack.peek(); // Should throw exception
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekAfterPoppingAllElements() {
        stack.push(1);
        stack.pop();
        stack.peek(); // Should throw exception
    }

    // isEmpty Method Tests
    @Test
    public void testIsEmptyOnNewStack() {
        assertTrue("New stack should be empty", stack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPush() {
        stack.push(1);
        assertFalse("Stack should not be empty after push", stack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPushAndPop() {
        stack.push(1);
        stack.pop();
        assertTrue("Stack should be empty after pushing and popping", stack.isEmpty());
    }

    @Test
    public void testIsEmptyMultiplePushPop() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertFalse("Stack should not be empty with one element", stack.isEmpty());
        stack.pop();
        assertTrue("Stack should be empty after popping all elements", stack.isEmpty());
    }

    // isFull Method Tests
    @Test
    public void testIsFullOnNewStack() {
        assertFalse("New stack should not be full", stack.isFull());
    }

    @Test
    public void testIsFullAfterFillingStack() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertTrue("Stack should be full after pushing capacity elements", stack.isFull());
    }

    @Test
    public void testIsFullOneElementShort() {
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        assertFalse("Stack should not be full with one space remaining", stack.isFull());
    }

    @Test
    public void testIsFullAfterPushAndPop() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        stack.pop();
        assertFalse("Stack should not be full after popping", stack.isFull());
    }

    @Test
    public void testIsFullSingleElementStack() {
        Stack tinyStack = new Stack(1);
        assertFalse("Empty single-element stack should not be full", tinyStack.isFull());
        tinyStack.push(1);
        assertTrue("Single-element stack with one element should be full", tinyStack.isFull());
    }

    // size Method Tests
    @Test
    public void testSizeOnNewStack() {
        assertEquals("New stack should have size 0", 0, stack.size());
    }

    @Test
    public void testSizeAfterSinglePush() {
        stack.push(1);
        assertEquals("Size should be 1 after one push", 1, stack.size());
    }

    @Test
    public void testSizeIncreasesWithPush() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
            assertEquals("Size should be " + i, i, stack.size());
        }
    }

    @Test
    public void testSizeDecreasesWithPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("Initial size should be 3", 3, stack.size());

        stack.pop();
        assertEquals("Size should be 2 after one pop", 2, stack.size());

        stack.pop();
        assertEquals("Size should be 1 after second pop", 1, stack.size());

        stack.pop();
        assertEquals("Size should be 0 after third pop", 0, stack.size());
    }

    @Test
    public void testSizeAtCapacity() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertEquals("Size should equal capacity", 5, stack.size());
    }

    // Integration Tests
    @Test
    public void testComplexSequenceOfOperations() {
        assertTrue("Should start empty", stack.isEmpty());

        stack.push(1);
        stack.push(2);
        assertEquals("Size should be 2", 2, stack.size());

        assertEquals("Peek should return 2", 2, stack.peek());
        assertEquals("Pop should return 2", 2, stack.pop());

        stack.push(3);
        stack.push(4);
        assertEquals("Size should be 3", 3, stack.size());

        assertEquals("Pop should return 4", 4, stack.pop());
        assertEquals("Pop should return 3", 3, stack.pop());
        assertEquals("Pop should return 1", 1, stack.pop());

        assertTrue("Should be empty at end", stack.isEmpty());
    }

    @Test
    public void testFillEmptyFillSequence() {
        // Fill the stack
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertTrue("Stack should be full", stack.isFull());

        // Empty the stack
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        assertTrue("Stack should be empty", stack.isEmpty());

        // Fill again
        for (int i = 0; i < 5; i++) {
            stack.push(i * 2);
        }
        assertTrue("Stack should be full again", stack.isFull());
        assertEquals("Top should be 8", 8, stack.peek());
    }

    @Test
    public void testBoundaryConditions() {
        Stack s = new Stack(3);

        // Test at each boundary
        s.push(1);
        assertFalse("Should not be full with 1 element", s.isFull());

        s.push(2);
        assertFalse("Should not be full with 2 elements", s.isFull());

        s.push(3);
        assertTrue("Should be full with 3 elements", s.isFull());

        s.pop();
        assertFalse("Should not be full after pop", s.isFull());
    }

    @Test
    public void testNegativeValues() {
        stack.push(-1);
        stack.push(-100);
        stack.push(-999);

        assertEquals("Should handle negative values", -999, stack.pop());
        assertEquals("Should handle negative values", -100, stack.pop());
        assertEquals("Should handle negative values", -1, stack.pop());
    }

    @Test
    public void testZeroValue() {
        stack.push(0);
        assertEquals("Should handle zero", 0, stack.peek());
        assertEquals("Should handle zero", 0, stack.pop());
    }

    @Test
    public void testLargeValues() {
        stack.push(Integer.MAX_VALUE);
        stack.push(Integer.MIN_VALUE);

        assertEquals("Should handle Integer.MIN_VALUE", Integer.MIN_VALUE, stack.pop());
        assertEquals("Should handle Integer.MAX_VALUE", Integer.MAX_VALUE, stack.pop());
    }
}
