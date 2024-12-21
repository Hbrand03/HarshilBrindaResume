/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2.pkg;

import java.util.ArrayList;

public class FarmGenerator extends Generator { //Food
    public FarmGenerator(int numberConstructed) {
        super("Farm", new ArrayList<>(), 3, numberConstructed, new Resource("Food"));
        // Assume construction cost for simplicity; you can add specific resources required for construction.
    }
}
