package Project2.pkg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TextManagementGame {
    private int round;
    private ArrayList<Resource> resources = new ArrayList<Resource>();
    private ArrayList<Generator> generators = new ArrayList<Generator>();

    private Scanner scanner;

    public TextManagementGame() {
        round = 1;       // Start at time 1
        scanner = new Scanner(System.in);
    }

    /**
     * Check if a method should run with a 1 in number chance.
     *
     * @return true if the method should run, false otherwise
     */
    public boolean haveEventThisTurn(int number) {
        Random random = new Random();
        int chance = random.nextInt(number); // Generates a random number between 0 (inclusive) and number (exclusive)
        return chance == 0; // Returns true with a 1 in number chance
    }

    /**
    * Prints the list of resources
    */
    public void viewResources(){
        for(Resource r : resources){
            System.out.println(r);
        }
    }

    /**
    * Prints the list of Generators
    */
    public void viewGenerators(){
        for(Generator b : generators){
            System.out.println(b);
        }
    }

    /**
     * Checks if a Generator can be constructed and then adds it to the list of Generators
     * TODO : ADD LOGIC
     */
    public void constructGenerator(){
        
    }

    /** 
     * Increments the time counter and then adds more resources based on what generators are present
     * TODO : Add calculations to generate resources for the next turn
     */
    public void endRound(){
        round++;
        
        // Update resources based on generator production rates
        for (Generator generator : generators) {
            Resource producedResource = generator.getProduct();
            int productionRate = generator.getResourceProductionRate() * generator.getNumberConstructed();
            producedResource.add(productionRate);

            System.out.println("Produced " + productionRate + " " + producedResource.getName() +
                    " using " + generator.getName() + " generators.");
        }

        System.out.println("End of round " + round + ". Resources added.");
        viewResources(); // Display the updated resources.
    }
    
    public void addGenerator(Generator generator) {
        generators.add(generator);
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public boolean isCriticalResourceEmpty(){
        for(Resource r : resources){
            if(r.isCritical() && r.getQuantity() == 0){
                return true;
            }
        }
        return false;
    }
    
    public void sortResourcesByQuantity() {
        Collections.sort(resources);
        System.out.println("Resources sorted by quantity:");
        viewResources(); // Display the sorted resources.
    }
    
    public void handleRandomEvent() {
        Random random = new Random();
        int eventIndex = random.nextInt(eventList.size()); // Assuming eventList is a list of available events.
        Event randomEvent = eventList.get(eventIndex);
        
        System.out.println("Random Event: " + randomEvent.getName());
        // TODO: Implement logic for the specific random event.
    }

    /**
     * Starts the game and manages the game loop.
     */
    public void start() {
        System.out.println("Welcome to the Text Management Game!"); 
        int oddsOfRandomEvent = 4; //a 25% chance of a random event occuring

        // Main game loop
        while (!isCriticalResourceEmpty()) {
            System.out.println("\nTime " + round);
            if(haveEventThisTurn(oddsOfRandomEvent)){
                //TODO add logic for random events
                System.out.println("A random event happened!");
            }
            System.out.println("Options:");
            System.out.println("1. Collect resources");
            System.out.println("2. Manage resources");
            System.out.println("3. Add a new Generator");
            System.out.println("4. End round");
            System.out.println("5. Quit game");
            System.out.println("6. Sort Resources by Quantity");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewResources();
                    break;
                case 2:
                    viewGenerators();
                    break;
                case 3: 
                    constructGenerator();
                    break;
                case 4:
                    endRound();
                    break;
                case 5:
                    System.exit(0);
                    break;
                case 6:
                    sortResourcesByQuantity();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Game Over! You ran out of resources.");
        System.out.println("You played for " + round + " rounds");
    }
    
    public static void main(String[] args) {
        TextManagementGame game = new TextManagementGame();
        game.start();
    }
}
