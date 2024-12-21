import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {
  @Test
  public void test1C() {
    Integer[] arr = new Integer[] {};
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(0, m.uniqueWithHashMap());
    assertEquals(0, m.uniqueWithoutHashMap());
  }

  @Test
  public void test2C() {
    Integer[] arr = new Integer[] { 3, -3, -1, 0, -1, 4, 0, 3, 4, 0 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(5, m.uniqueWithHashMap());
    assertEquals(5, m.uniqueWithoutHashMap());
  }

  @Test
  public void test3C() {
    Integer[] arr = new Integer[] { 4, 3, -1, 1, -3, -1, 1, -5, -3, -4 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(7, m.uniqueWithHashMap());
    assertEquals(7, m.uniqueWithoutHashMap());
  }

  @Test
  public void test4C() {
    Integer[] arr = new Integer[] { 0, 0, 0, -3, 0, -1, -3, 1, 1, 2 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(5, m.uniqueWithHashMap());
    assertEquals(5, m.uniqueWithoutHashMap());
  }

  @Test
  public void test5C() {
    Integer[] arr = new Integer[] { 8, 7, -1, -2, 9, 0, 3, 2, -2, 3, -2, 9, 2, -3, 3 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(9, m.uniqueWithHashMap());
    assertEquals(9, m.uniqueWithoutHashMap());
  }

  @Test
  public void test6C() {
    Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(10, m.uniqueWithHashMap());
    assertEquals(10, m.uniqueWithoutHashMap());
  }

  @Test
  public void test7C() {
    Integer[] arr = new Integer[] { -4, 3, 6, -2, -1, -4 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(5, m.uniqueWithHashMap());
    assertEquals(5, m.uniqueWithoutHashMap());
  }

  @Test
  public void test8C() {
    Integer[] arr = new Integer[] { 0, -1, 0 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(2, m.uniqueWithHashMap());
    assertEquals(2, m.uniqueWithoutHashMap());
  }

  @Test
  public void test9C() {
    Integer[] arr = new Integer[] { 1, 2, -1, 40, 1, 40, 0, 0, -3, 2, 2, -2, -5, 0, 1, -4, -5 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(9, m.uniqueWithHashMap());
    assertEquals(9, m.uniqueWithoutHashMap());
  }

  @Test
  public void test10C() {
    Integer[] arr = new Integer[] { 4, 5, 5, 4, 1, 5, -3, 4, -1, -2, -2, -2, -2, -2, -2, 1, 4, 5, -5 };
    Main<Integer> m = new Main<Integer>(arr);
    assertEquals(7, m.uniqueWithHashMap());
    assertEquals(7, m.uniqueWithoutHashMap());
  }
}
