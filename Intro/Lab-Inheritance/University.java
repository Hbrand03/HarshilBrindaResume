import java.util.ArrayList;

/**
 *
 * @author Harshil
 */
public class University implements UniversitySpecification {
    private String name;
    private ArrayList<Person> personnel;
    
    public University(String n){
        this.name = n;
        this.personnel = new ArrayList<>();
        
    }
    
    public ArrayList<Person> getPersonnel(){
        return personnel;
    }

    @Override
    public void setUp(ArrayList<Person> personnel) {
        this.personnel.addAll(personnel);
    }

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (Person person : personnel){
            if(person instanceof Student){
                students.add((Student) person);
            }
        }
        return students;
    }

    @Override
    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professors = new ArrayList<>();
        for (Person person : personnel){
            if(person instanceof Professor){
                professors.add((Professor) person);
            }
        }
        return professors;
    }

    @Override
    public void newStudent(Student s) {
            personnel.add(s);
    }

    @Override
    public void newProfessor(Professor p) {
        personnel.add(p);
    }

    
   
    
    
    
}
