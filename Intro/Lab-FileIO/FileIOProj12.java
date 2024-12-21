//Harshil Brinda
//Thursday Lab
package fileio.proj12;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import Classes.Student;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

public class FileIOProj12 {
    public static void main(String[] args) {
        Scanner fileScanner;
        ArrayList<Student>students = new ArrayList();
        try {
            fileScanner = new Scanner(new File("inputData.txt"));
            
            String line;
            while(fileScanner.hasNext()){
            line = fileScanner.nextLine();
            if("student".equals(line.substring(0,line.indexOf(",")))){
                String[] attributes = line.split(",");
                if(attributes.length== 7){
                    String firstName = attributes[1];
                    String lastName = attributes[2];
                    int ID = Integer.parseInt(attributes[3]);
                    String major = attributes[4];
                    double gpa = Double.parseDouble(attributes[5]);
                    int credits = Integer.parseInt(attributes[6]);
                    Student a = new Student(firstName,lastName,ID, major, gpa,credits);
                    students.add(a);
                }
            }
            }
            fileScanner.close();
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Caught FileNotFoundException for inputData.txt. Try again making sure the file name and path are correct");
        }
        Collections.sort(students);
        /* for(Student s : students){
            s.display();
            System.out.println(s.getGPA());
        } */
        FileOutputStream fs;
        try{
            fs = new FileOutputStream("ScholarshipCandidates.txt");
            PrintWriter outFS = new PrintWriter(fs);
            outFS.println("Our top candidates for the scholarship are: ");
            for(Student student : students){
                if(student.getGPA() >= 3.5){
                    System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println("GPA: " + student.getGPA());
                    System.out.println("Major: " + student.getMajor());
                    System.out.println();
                }
            }
            outFS.println("Our middle candidates for the scholarship are: ");
            for(Student student : students){
                if(student.getGPA() >= 3.2 && student.getGPA() < 3.5 ){
                    System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println("GPA: " + student.getGPA());
                    System.out.println("Major: " + student.getMajor());
                    System.out.println();
                }
            }
            outFS.println("Ineligible candidates for the scholarship are: ");
            for(Student student : students){
                if(student.getGPA() <  3.2){
                    System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println("GPA: " + student.getGPA());
                    System.out.println("Major: " + student.getMajor());
                    System.out.println();
                }
            }
            outFS.close();
            fs.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Caught FileNotFoundException for outData.txt. Try again making sure the file name and path are correct.");
        } catch(IOException ex) {
            System.out.println("Caught IOException when closing output stream. Try again");
        }
       
        for(Student student : students){
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("GPA: " + student.getGPA());
            System.out.println("Major: " + student.getMajor());
            System.out.println();
        }
    }
}
