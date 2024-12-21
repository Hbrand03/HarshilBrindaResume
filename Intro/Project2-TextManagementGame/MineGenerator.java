/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project2.pkg;

import java.util.ArrayList;

public class MineGenerator extends Generator { //Ore
    public MineGenerator(int numberConstructed) {
        super("Mine", new ArrayList<>(), 2, numberConstructed, new Resource("Ore"));
        // Assume construction cost for simplicity; you can add specific resources required for construction.
    }
}
