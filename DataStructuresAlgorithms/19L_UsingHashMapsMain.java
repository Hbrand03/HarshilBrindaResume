import java.util.HashMap;
import java.util.HashSet;

public class Main<T extends Comparable<T>> {
  T[] buffer;

  public Main(T[] arr) {
    buffer = arr;
  }

  public int uniqueWithoutHashMap() {
    HashSet<T> set = new HashSet<T>();
    for (T t : buffer) {
      set.add(t);
    }

    return set.size();
  }

  public int uniqueWithHashMap() {
    HashMap<T, Integer> map = new HashMap<T, Integer>();

    for (T item : buffer) {
      map.putIfAbsent(item, 1);
    }

    return map.keySet().size();
  }

  public static void main(String[] args) {
    Main<Integer> m = new Main<Integer>(new Integer[] { 3, -3, -1, 0, -1, 4, 0, 3, 4, 0 });

    if (m.uniqueWithoutHashMap() == 5) {
      System.out.println("uniqueWithoutHashMap works!");
    } else {
      System.out.println("uniqueWithoutHashMap doesn't work!");
    }

    if (m.uniqueWithHashMap() == 5) {
      System.out.println("uniqueWithHashMap works!");
    } else {
      System.out.println("uniqueWithHashMap doesn't work!");
    }
  }
}
