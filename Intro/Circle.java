package RectangleTest;

/***
 * @author Harshil
 */

//Part C works, the circle constructor has the description from running Javadoc
//Part D: 
public class Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   private double radius;
   private String color;
   
   /**
    * The default constructor with no argument, sets radius/color to default values.
   */
   public Circle() {
      radius = 1.0;
      color = "red";
   }

/**
 * @param r the radius
 * @param clr the color
 */
   public Circle(double r, String clr) {
      radius = r;
      color = clr;
   }

   /***
    * @return the radius
    */
   //A public method for retrieving the radius
   public double getRadius() {
     return radius;
   }

   // A public method for retrieving the area of circle
   /**
    * @return gets circle area
    */
   public double getArea() {
     double area = calculateArea();
      return area;
   }

   /**
    * @return calculates circle area
    */
   // A private method for computing the area of circle
   private double calculateArea(){
     return radius*radius*Math.PI;
   }
}