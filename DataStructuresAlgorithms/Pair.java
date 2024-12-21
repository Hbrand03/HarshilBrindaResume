package GenericsPractice;
// TODO: replace ... with appropriate code

// new Pair<Integer>(2, 3).min() => 2
// new Pair<String>("2", "3").min() => "2"
public class Pair<T extends Comparable<T>> 
{

   private T e1;
   private T e2;

   /**
      Constructs a Pair.
      @param e1 is the first member
      @param e2 is the second member
   */
   public Pair(T e1, T e2)
   {
      this.e1 = e1;
      this.e2 = e2;
   }

   public T min()
   {
      T min = e1;
      if (e2.compareTo(min) < 0) {
         min = e2;
      }

      return min;
   }
   
   public static void main(String[] args)
   {  
      Pair<Integer> p = new Pair<Integer>(2, 3);
      System.out.println(p.min());
      
      Pair<String> s = new Pair<String>("2", "3");
      System.out.println(s.min());
      
      Employee e1 = new Employee(2, 3);
      Employee e2 = new Employee(2, 3);

      System.out.println(e1.compareTo(e2));
   }
}