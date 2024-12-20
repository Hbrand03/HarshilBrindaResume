/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.ArrayList;

/**
 *
 * @author harsh
 */
public class FastFoodKitchen {
    
    private ArrayList<Order> orderList = new ArrayList<>();
    private static int nextOrderNum = 1;
    /**
     * none since constructor that initializes
     */
    public FastFoodKitchen()
    {
        Order order1 = new Order(3,15,4,10,false,nextOrderNum);
        incrementNextOrderNum();
        orderList.add(order1);
        
        Order order2 = new Order(0,0,3,3,false,2);
        incrementNextOrderNum();
        orderList.add(order2);
        
        Order order3 = new Order(1,1,0,2,false,3);
        incrementNextOrderNum();
        orderList.add(order3);
    }
    
    /**
     *
     * @return next order number
     */
    public int getNextOrderNum()
    {
        return nextOrderNum;
    }
    
    private static void incrementNextOrderNum()
    {
        nextOrderNum++;
    }
    
    /**
     *
     * @param ham
     * @param cheese
     * @param veggie
     * @param soda
     * @param toGo
     * @return next order number
     */
    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo)
    {
        Order order = new Order(ham, cheese, veggie, soda, toGo,nextOrderNum);
        orderList.add(order);
        incrementNextOrderNum();
              
        System.out.println("Order number: ");
        return getNextOrderNum();
    }
    
    /**
     *
     * @return if the last order can be cancelled or not
     */
    public boolean cancelLastOrder()
    {
        if(nextOrderNum > 0)
        {
            nextOrderNum--;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *
     * @return how many orders left
     */
    public int getNumOrdersPending()
    {
        return orderList.size();
    }
    
    public boolean isOrderDone(int orderID){
         for (Order order : orderList) {
            if (order.getOrderNum()== orderID) {
                // Order is still in progress
                return false;
            }
        }
        return true;
    }
    
    public boolean cancelOrder(int orderID) {
         for (Order order : orderList) {
            if (order.getOrderNum()== orderID) {
                orderList.remove(order);
                return true;
            }
        }
        return false;
    }

    
    
}
