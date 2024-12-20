import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Harshil
 */
public interface UniversitySpecification {
    /**
     * setUp adds the initial personnel (students and professors) of a university
     *
     * @param personnel - the initial list of personnel of this university
     */
    public void setUp(ArrayList<Person> personnel);

    /**
     * getStudents get students from personnel list
     *
     * @return a list of students
     */
    public ArrayList<Student> getStudents();

    /**
     * getProfessors get professors from personnel list
     *
     * @return a list of professors
     */
    public ArrayList<Professor> getProfessors();

    /**
     * add a new student to university personnel
     *
     * @param s - new student to add
     */
    public void newStudent(Student s);

    /**
     * add a new professor to university personnel
     *
     * @param p - new professor to add
     */
    public void newProfessor(Professor p);


}
