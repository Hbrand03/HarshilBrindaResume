                    
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harshil
 */
public class Student extends Person implements Comparable<Student> {
    private String major;
    private double gpa;
    private int credits;
    private double balance;
    private boolean transfer;
    private ArrayList<String> enrolledCourses;
    
    public Student(String fName, String lName, int id, String major, double gpa, int credits){
        super(fName, lName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        balance = 0;
        enrolledCourses = new ArrayList();
    }
    
    public String getMajor(){
        return major;
    }
    
    public double getGPA(){
        return gpa;
    }
    
    public int getCredits(){
        return credits;
    }
    
    public boolean isTransfer(){
        return transfer;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public ArrayList<String> getEnrolledCourses(){
        return enrolledCourses;
    }
    
    public void setMajor(String newValue){
        major = newValue;
    }
    
    public void setGPA(double newValue){
        gpa = newValue;
    }
    
    public void setCredits(int newValue){
        credits = newValue;
    }
    
    public void setTransfer(boolean newValue){
        transfer = newValue;
    }
    
    public void setBalance(double newValue){
        balance = newValue;
    }
    
    public void addCourse(String newValue){
        enrolledCourses.add(newValue);
    }
    
    public boolean dropCourse(String courseToDrop) {
   
        for (int i = 0; i < enrolledCourses.size(); i++) {
            if (enrolledCourses.get(i).equals(courseToDrop)) {
                enrolledCourses.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void display(){
       // super.display();
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("ID: " + this.getId() + "\tMajor: " + major);
        System.out.println("GPA: " + gpa + "\tCredits Applied: " + credits);
        System.out.println("Ernolled Courses: ");
        
        for(int i = 0; i < enrolledCourses.size(); i++){
            System.out.println("\t" + enrolledCourses.get(i));
        }
     
    } 
    
    @Override
    public String toString(){
        return "Student - " + this.getFirstName() + " " + this.getLastName();
    }
    
    @Override
    public int compareTo(Student o){
        
        
        System.out.println(o.getId());
        
        Student otherStudent = (Student) o;
        
        double sGPA = this.gpa;
        double oGPA = otherStudent.gpa;
        
        System.out.println("Students Gpa: " + sGPA + " and " + oGPA);
//        throw new UnsupportedOperationException("Not supported yet.");
         if (sGPA > oGPA) {
            return 1; 
        } else if (sGPA < oGPA) {
            return -1; 
        } else {
            return 0; 
        }
        
    }
    }
    

