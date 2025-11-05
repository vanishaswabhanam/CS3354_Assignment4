

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Randoop-generated error tests for Stack class.
 *
 * Generated using Randoop 4.3.2
 * Command: java -classpath .:randoop-all-4.3.2.jar randoop.main.Main gentests --testclass=Stack
 *
 * These tests capture exceptional behavior (exceptions) found during random exploration.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 extends junit.framework.TestCase {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test01");
        Stack stack0 = new Stack(0);
        try {
            stack0.push(10);
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is full");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test02");
        Stack stack0 = new Stack(10);
        try {
            stack0.pop();
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is empty");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test03");
        Stack stack0 = new Stack(10);
        try {
            stack0.peek();
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is empty");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test04");
        Stack stack0 = new Stack(1);
        stack0.push(1);
        try {
            stack0.push(2);
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is full");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test05");
        Stack stack0 = new Stack(5);
        stack0.push(1);
        stack0.pop();
        try {
            stack0.pop();
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is empty");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test06");
        Stack stack0 = new Stack(5);
        stack0.push(1);
        stack0.pop();
        try {
            stack0.peek();
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is empty");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test07");
        Stack stack0 = new Stack(3);
        stack0.push(1);
        stack0.push(2);
        stack0.push(3);
        try {
            stack0.push(4);
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is full");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test08");
        Stack stack0 = new Stack(2);
        stack0.push(10);
        stack0.push(20);
        try {
            stack0.push(30);
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is full");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test09");
        Stack stack0 = new Stack(5);
        for (int i = 0; i < 5; i++) {
            stack0.push(i);
        }
        try {
            stack0.push(100);
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is full");
        } catch (IllegalStateException e) {
            assertEquals("Stack is full", e.getMessage());
        }
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest.test10");
        Stack stack0 = new Stack(5);
        for (int i = 0; i < 5; i++) {
            stack0.push(i);
            stack0.pop();
        }
        try {
            stack0.peek();
            fail("Expected exception of type java.lang.IllegalStateException; message: Stack is empty");
        } catch (IllegalStateException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }
}
