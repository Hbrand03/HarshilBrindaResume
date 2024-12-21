package ConcertTicket;

import java.util.Arrays;

/**
 * This class allet which can store any number of concert tickets.
 *
 * @version Fall 2019
 */
public class Wallet {

    /**
     * Array of ConcertTicket objects
     */
    protected ConcertTicket[] tickets = new ConcertTicket[10];
    private int size = 0;

    /**
     * Add a concert ticket into the array
     *
     * @param ct a concert ticket being added to the wallet
     */
    public void add(ConcertTicket ct) {
        if (this.size == this.tickets.length) {
            this.resize();
        }
        
        this.tickets[this.size] = ct;
        this.size++;
    }

    /**
     * Resizes the wallet so that you can fit more tickets.
     *
     */
    public void resize() {
        this.tickets = Arrays.copyOf(this.tickets, 2 * this.tickets.length);
    }

    /**
     * Converts the wallet into a string representation for easy reading.
     *
     * @return a string representation of the wallet
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.tickets, size));
    }

    /**
     * Returns how many tickets are in the wallet.
     *
     * @return the size of the wallet
     */
    public int getSize() {
        return this.size;
    }
    
     /**
     * Returns the size of the wallet.
     *
     * @return the size of the wallet
     */
    public int getLength() {

        return this.tickets.length;
    }
    
     /**
     * Removes the most recently added concert ticket from the wallet
     *
     * @return the concert ticket removed from the wallet
     */
    public ConcertTicket remove() {

        // TODO: Create a ConcertTicket reference variable (DO NOT create a 
        // new ConcertTicket – JUST create the reference variable)
        // Create a ConcertTicket reference variable
        ConcertTicket referenceTicket = null;

        if (this.size > 0) {
            // TODO: Use the size variable 
            //(which always points at the next empty 
            // slot) to get the last added ConcertTicket from the array:
            referenceTicket = this.tickets[size - 1];
            
            // TODO: Set that array slot to null:
            // Set that array slot to null:
            this.tickets[this.size - 1] = null;
            
            // TODO: Decrement the size variable:
            this.size--;
            
        }
        // TODO: Return the ConcertTicket:
        return referenceTicket;
    }

}
