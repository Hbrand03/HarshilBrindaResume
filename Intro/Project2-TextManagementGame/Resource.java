package Project2.pkg;

/**
 * The Resource class represents a generic resource in the game.
 * Resources have a name, a quantity, and a status of critical or not critical.
 */
class Resource implements Score, Comparable<Resource>{
    private String name;
    private int quantity;
    private boolean isCritical;

    public Resource(String name) {
        this.name = name;
        this.quantity = 0;
        this.isCritical = false;
    }
    
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isCritical(){
        return isCritical;
    }

    public void setIsCrticial(boolean isCritical){
        this.isCritical = isCritical;
    }

    public void add(int amount) { //quantity of the resource
        quantity += amount;
    }
    
    public void consume(int amount) { //resource consumption based on quantity if available
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            quantity = 0;
            System.out.println("Not enough " + name + " to consume.");
        }
    }

    @Override
    public int compareTo(Resource other) {
        return Integer.compare(this.quantity, other.quantity);
    }
    @Override
    public int scoreImpact() {
        return quantity;
    }
    
}