

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EvoSuite-generated unit tests for Stack class.
 *
 * Generated using EvoSuite 1.0.6
 * Command: java -jar evosuite.jar -class Stack -projectCP target/classes
 *
 * EvoSuite uses search-based software testing to automatically generate
 * test cases with assertions that aim for maximum code coverage.
 */
public class EvoSuiteRegressionTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      stack0.push(1433);
      int int0 = stack0.size();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Stack stack0 = new Stack(1);
      stack0.push(1);
      int int0 = stack0.pop();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      stack0.push(0);
      int int0 = stack0.peek();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Stack stack0 = new Stack(1);
      boolean boolean0 = stack0.isEmpty();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Stack stack0 = new Stack(1);
      stack0.push(1);
      boolean boolean0 = stack0.isFull();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      int int0 = stack0.size();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      boolean boolean0 = stack0.isFull();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      stack0.push(1433);
      boolean boolean0 = stack0.isEmpty();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Stack stack0 = new Stack(2);
      stack0.push(2);
      stack0.push(2);
      try {
        stack0.push(2);
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
         assertEquals("Stack is full", e.getMessage());
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      try {
        stack0.pop();
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
         assertEquals("Stack is empty", e.getMessage());
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Stack stack0 = new Stack(1433);
      try {
        stack0.peek();
        fail("Expecting exception: IllegalStateException");
      } catch(IllegalStateException e) {
         assertEquals("Stack is empty", e.getMessage());
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Stack stack0 = new Stack(5);
      stack0.push((-1));
      stack0.push(5);
      stack0.push(0);
      int int0 = stack0.size();
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Stack stack0 = new Stack(5);
      stack0.push(5);
      stack0.push(5);
      stack0.push(5);
      stack0.push(5);
      stack0.push(5);
      boolean boolean0 = stack0.isFull();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Stack stack0 = new Stack(10);
      stack0.push(10);
      stack0.push((-1));
      stack0.pop();
      int int0 = stack0.peek();
      assertEquals(10, int0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Stack stack0 = new Stack(3);
      stack0.push(3);
      stack0.push(0);
      stack0.push(3);
      boolean boolean0 = stack0.isFull();
      assertTrue(boolean0);

      int int0 = stack0.pop();
      assertEquals(3, int0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Stack stack0 = new Stack(100);
      for(int i = 0; i < 50; i++) {
        stack0.push(i);
      }
      assertEquals(50, stack0.size());
      assertFalse(stack0.isFull());
      assertFalse(stack0.isEmpty());
  }
}
