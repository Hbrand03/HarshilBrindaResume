/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author harsh
 */
public class Order {
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 3;
    
    public Order(int nH, int nC, int nV, int nS, boolean oTG, int oN)
    {
        numHamburgers = nH;
        numCheeseburgers = nC;
        numVeggieburgers = nV;
        numSodas = nS;
        orderToGo = oTG;
        orderNum = oN;
    }
    
    public int getHamburgers()
    {
        return numHamburgers;
    }
    public void setHamburgers(int num)
    {
        if(num <0)
        {
            System.out.println("Error: parameter passed in is less than 0");
        }
        else
        {
            numHamburgers = num;
        }
    }
    
    public int getCheeseburgers()
    {
        return numCheeseburgers;
    }
    public void setCheeseburgers(int num)
    {
        if(num <0)
        {
            System.out.println("Error: parameter passed in is less than 0");
        }
        else
        {
            numCheeseburgers = num;
        }
    }
    
    public int getVeggieburgers()
    {
        return numVeggieburgers;
    }
    public void setVeggieburgers(int num)
    {
        if(num <0)
        {
            System.out.println("Error: parameter passed in is less than 0");
        }
        else
        {
            numVeggieburgers = num;
        }
    }
    
    public int getSodas()
    {
        return numSodas;
    }
    public void setSodas(int num)
    {
        if(num <0)
        {
            System.out.println("Error: parameter passed in is less than 0");
        }
        else
        {
            numSodas = num;
        }
    }
    
    public boolean isOrderToGo()
    {
        return orderToGo;
    }
    public void setOrderToGo(boolean order)
    {
        orderToGo = order;
    }
    
    public int getOrderNum()
    {
        return orderNum;
    }
    public void setOrderNum(int num)
    {
        orderNum = num;
    }

    
 
}
