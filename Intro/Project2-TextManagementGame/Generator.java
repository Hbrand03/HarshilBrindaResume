package Project2.pkg;

import java.util.ArrayList;

/**
 * The Generator class represents a generic resource generating item in the game.
 * Generators have a name, a construction cost, and a resource production rate.
 */
public class Generator {
    private String name;
    private ArrayList<Resource> constructionCost; //the cost in resources required to construct the Generator
    private int resourceProductionRate; //the rate at which the Generator produces resources per unit of time
    private int numberConstructed; //the number of units of this generator constructed at this time
    private Resource product; //the type of resource this generator produces

    public Generator(String name, ArrayList<Resource> constructionCost, int resourceProductionRate, int numberConstructed, Resource product) {
        this.name = name;
        this.constructionCost = constructionCost;
        this.resourceProductionRate = resourceProductionRate;
        this.numberConstructed = numberConstructed;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Resource> getConstructionCost() {
        return constructionCost;
    }

    public int getResourceProductionRate() {
        return resourceProductionRate;
    }

    public int getNumberConstructed() {
        return numberConstructed;
    }

}