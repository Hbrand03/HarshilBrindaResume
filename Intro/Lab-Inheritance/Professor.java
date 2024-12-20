
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harshil
 */
public class Professor extends Person {
    private String department;
    private double salary;
    private ArrayList<Student> advisees;
    
    public Professor(String fName, String lName, int id, String dept, double salr){
        super(fName, lName, id);
        this.department = dept;
        this.salary = salr;
        advisees = new ArrayList();       
    }
    
    public String getDepartment(){
        return department;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public ArrayList<Student> getAdvisees(){
        return advisees;
    }
    
    public void setDepartment(String newValue){
        department = newValue;
    }
    
    public void setSalary(double newValue){
        salary = newValue;
    }
    
    public void addAdvisee(Student newValue){
    advisees.add(newValue);
    }
    
    public boolean removeAdvisee(int adviseeName){
        
        for(int i = 0; i < advisees.size(); i++){
            if(advisees.get(i).getId() == adviseeName){
                advisees.remove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
   public void display(){
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName() + "\tID: " + this.getId());        
        System.out.println("Department: " + department + "\tSalary: $" + salary);
//        System.out.println("Advisees:");
//        for(Student s : advisees){
//            System.out.println("\t" + s.getFirstName() + " " + s.getLastName());
        }
       
   
   
    @Override
   public String toString(){
       return "Professor - " + this.getFirstName() + " " + this.getLastName();
   }
}

