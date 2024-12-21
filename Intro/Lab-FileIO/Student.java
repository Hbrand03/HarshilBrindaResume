package Classes;

public class Student implements Comparable<Student> {

    private final String firstName;
    private final String lastName;
    private final int id;
    private String major;
    private double gpa;
    private int credits;

    public Student(String fName, String lName, int id, String major, double gpa, int credits) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = id;
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void display() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("ID: " + this.id + "\tMajor: " + this.major);
        System.out.println("GPA: " + this.gpa + "\tCredits Applied: " + this.credits);
    }

    @Override
    public String toString() {
        return "Student - " + this.id;
    }
    
    @Override
    public int compareTo(Student o) {
        double oGPA = o.getGPA();
        double sGPA = gpa;        
        if(sGPA > oGPA){
            return 1;
        }else if(sGPA < oGPA){
            return -1;
        }else return 0;
    }
}