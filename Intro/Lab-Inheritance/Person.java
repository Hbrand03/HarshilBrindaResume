
/**
 *
 * @author Harshil
 */
abstract public class Person {
    private String firstName;
    private String lastName;
    private int id;
    
    public Person(String fName, String lName, int id){
        this.firstName = fName;
        this.lastName = lName;
        this.id = id;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getId(){
        return id;
    }
    
    public abstract void display();
//        System.out.print("Name: " + firstName);
//        System.out.println(" " + lastName);
//        System.out.println("ID: " + id);     
    
    
    @Override
    public boolean equals(Object other){
        if (other == null){
        return false;
    } 
    
    if (this.getClass() != other.getClass()){
        return false;
    }
    
    return this.getId() == ((Person) other).getId();
}
}
