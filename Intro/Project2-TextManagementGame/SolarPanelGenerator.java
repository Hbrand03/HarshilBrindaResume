/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2.pkg;

import java.util.ArrayList;

public class SolarPanelGenerator extends Generator { //Energy
    public SolarPanelGenerator(int numberConstructed) {
        super("Solar Panel", new ArrayList<>(), 5, numberConstructed, new Resource("Energy"));
        // Assume construction cost for simplicity; you can add specific resources required for construction.
    }
}

