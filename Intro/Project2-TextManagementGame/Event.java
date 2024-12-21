package Project2.pkg;


/**
 * The Event class represents a generic randomly occuring event in the game.
 * Events have a name
 */
public class Event {
    private String name;
    
    public Event(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }

}