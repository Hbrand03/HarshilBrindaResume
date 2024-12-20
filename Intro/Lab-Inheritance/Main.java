
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Harshil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*** Part A ***");
        
        //Person p = new Person("Raya", "Whitaker", 800555555);
        //p.display();
        
        
        
//        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
//        System.out.println(s1);
//        s1.setTransfer(true);
//        s1.setBalance(100);
//        s1.addCourse("Java Programming");
//        s1.addCourse("Calculus");
//        
//        s1.display();
        
//        if (s1.dropCourse("Spanish")){
//            System.out.println("The class has been dropped");
//        } else {
//            System.out.println("You are not enrolled in this course. " + "No courses have been dropped.");
//        }
//        
//        ArrayList<String> enrolledCourses = s1.getEnrolledCourses();
//        System.out.println("You are enrolled in the following courses:");
//        for (String course : enrolledCourses){
//            System.out.println(course);
//        }
//    
        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s1);

        System.out.println("*** Part C ***");
        
        Student s2 = new Student("Katherine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);
        Student s5 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s1.equals(s5));
        System.out.println(s1.equals(s4));
        
        
       //Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
//     
//        prof1.addAdvisee(s2);
//        prof1.addAdvisee(s3);
//        prof1.addAdvisee(s4);
//        
//        prof1.display();
//        
//        if (prof1.removeAdvisee(902)){
//            System.out.println("The advisee has been removed");
//        } else {
//            System.out.println("This student is not an advisee of professor" + prof1.getLastName() + " " + prof1.getLastName());          
//        }
//        
//        ArrayList<Student> myAdvisees = prof1.getAdvisees();
//        System.out.println("Professor " + prof1.getFirstName() + " " + prof1.getLastName() + " advisees:");
//        for (Student s : myAdvisees){
//            System.out.println(s.getFirstName() + " " + s.getLastName());
//        }

          Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
          System.out.println(prof1);
          System.out.println(s1.equals(prof1));
          
          
    //Module 7 Part D
    //This person array can hold the subclass objects too
    Person[] personArray = {s1, s2, prof1};
    //The shape ArrayList can add subclass objects too
    ArrayList<Person> personList = new ArrayList();
    personList.add(s1);
    personList.add(s2);
    personList.add(prof1);
    
        System.out.println("Content of personList:");
        
        for(Person person: personList){
            System.out.println(person);
        }
        
       ArrayList<Person> contactList = new ArrayList();
       
      // contactList.add(p);
       contactList.add(s1);
       contactList.add(s2);
       contactList.add(s3);
       contactList.add(s4);
       contactList.add(prof1);
       
      //Person p2 = new Person("Elle", "Kambol", 800);
     // contactList.add(p2);
      
      Professor prof2 = new Professor("Frank", "Black", 801, "Math", 85000);
      contactList.add(prof2);
      
      Student s6 = new Student("Grace", "Maxeem", 903, "Psychology", 3.4, 95);
      contactList.add(s6);
      
      for(Person list : contactList){
          list.display();
      }
      
        System.out.println("*** Part B***");
        
        for (Person person : contactList){
            showProfile(person, 903);
        }
        
        Person p3 = new Student("Maya", "Adams", 700, "Music", 3.5, 105);
        System.out.println(((Student)p3).getGPA());
        
       // Person p4 = new Person("Bob", "Lowe", 701);
       // if(p4 instanceof Student){
       //     System.out.println(((Student) p4).getGPA());
        //}
        
        for(Person list : contactList){
            if(list instanceof Student){
                Student student = (Student) list;
                if(student.getGPA() > 3.5){
                    System.out.println("Eligible for scholarship: " + student.getFirstName() + " " + student.getLastName());
                }
            }
        }
        
        for(Person person : contactList){
            if(person instanceof  Professor){
                Professor professor = (Professor) person;
                if (professor.getDepartment().equals("CS")) {
                System.out.println("Professor in CS Department: " + professor.getFirstName() + " " + professor.getLastName());
            }
           }
        }
      
        
        int compareStudents = s4.compareTo(s1);
        System.out.println(compareStudents);
        
        ArrayList<Student> students = new ArrayList();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        
        Collections.sort(students);
        for(Student s: students){
            System.out.println(s.getGPA());
        }
    }
    
    
     public static void showProfile(Person p, int id){
          if(p.getId() == id)
          {
              p.display();
          }
      }
     
}
    
  
