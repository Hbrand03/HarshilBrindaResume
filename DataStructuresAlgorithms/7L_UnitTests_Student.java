package UnitTesting;

public class Student implements Comparable<Student> {
    String name;
    char grade;

    public Student() {
    }

    public Student(String n, char g) {
        name = n;
        grade = g;
    }

    public int compareTo(Student other) {
        if (grade == other.grade) {
            if (name.charAt(0) == other.name.charAt(0)) {
                return 0;
            } else {
                return name.charAt(0) - other.name.charAt(0);
            }
        } else {
            return other.grade - grade;
        }
    }
}