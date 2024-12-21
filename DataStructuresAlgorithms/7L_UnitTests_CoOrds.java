package UnitTesting;

     public class CoOrds implements Comparable<CoOrds> {
         int x, y;

         public CoOrds() {
             x = y = 0;
         }

         public CoOrds(int X, int Y) {
             x = X;
             y = Y;
         }

         public int compareTo(CoOrds other) {
             if (x != other.x) {
                 return x - other.x;
             } else {
                 return y - other.y;
             }
         }
     }