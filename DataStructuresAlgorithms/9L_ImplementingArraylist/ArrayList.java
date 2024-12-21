package DataStructures;

import Exceptions.*;

import java.util.Arrays;

import ADTs.*;

public class ArrayList<T extends Comparable<T>> implements ListADT<T> {
    /** The number of elements in the list. */
    int size; // how many elements in the list
    /** The capacity of the ArrayList */
    int capacity; //maximum number of elements the list can hold 
    /** The array used as the underlying data structure for the list. */
    T[] buffer; // 
/**
 * Default constructor. Creates an ArrayList with a dafulat capacity of 15. 
 */
    @SuppressWarnings("unchecked")
    public ArrayList() { 
        size = 0;
        capacity = 15;
        buffer = (T[]) new Comparable[capacity]; 
    } 

    /**
     * Creates an ArrayList with the specified capacity.
     * 
     * @param capacity for capacity of the ArrayList
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) { 
        size = 0;
        this.capacity = capacity; 
        buffer = (T[]) new Comparable[capacity]; 
    }

    
    /**
     * Returns true if the list is empty, false otherwise.
     * 
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty( ) { 
        return size == 0; 
    }
  
    
    public int size() { 
        return size; 
    }

    
    public void addFirst(T element) { 
        shiftRight(0);
        buffer[0] = element;
    }

    
    public void addLast(T element) { 
        resizeIfNeeded(); 

        buffer[size] = element;
        size = size + 1; 
    }

    
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException { 
        throwECEIfNecessary(null);

       int indexOfExisting = indexOf(existing); 
       if (indexOfExisting == -1){
           throw new ElementNotFoundException("Element" + existing + "not found");
       }

       shiftRight(indexOfExisting + 1);
       buffer[indexOfExisting + 1] = element; 
    }

    
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException { 
        throwECEIfNecessary(null);

        int indexOfElement = indexOf(element); 
        if (indexOfElement == -1){
            throw new ElementNotFoundException("Element" + element + "not found");
        }

        T removedElement = buffer[indexOfElement]; 
        shiftLeft(indexOfElement + 1);
        return removedElement;
    }

    
    public T removeFirst() throws EmptyCollectionException { 
        throwECEIfNecessary(null);

        T firstElement = buffer[0]; 
        shiftLeft(1);
        return firstElement;

    }

    
    public T removeLast() throws EmptyCollectionException { 
        throwECEIfNecessary(null);

        T lastElement = buffer[size - 1]; 
        buffer[size - 1] = null; 
        size = size - 1; 

        return lastElement;

    }

    
    public T first() throws EmptyCollectionException { 
        throwECEIfNecessary(null);
        return buffer[0]; 
    }

    
    public T last() throws EmptyCollectionException { 
        throwECEIfNecessary(null);
        return buffer[size - 1];
    }

    
    public boolean contains(T element) throws EmptyCollectionException { 
       return indexOf(element) != -1;
    }

    
    public int indexOf(T element) { 
        for (int i = 0; i < size; i++){
            if (buffer[i].compareTo(element) == 0){
                return i;
            }
        }

        return -1; 
    }
    
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException { 
        throwECEIfNecessary(null);

        if(index < 0 || index >= size){
            throw new InvalidArgumentException("Index" + index + "Invalid index");
        }
        return buffer[index];
    }

    
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException { 
        throwECEIfNecessary(null);

        if(index < 0 || index >= size){
            throw new InvalidArgumentException("Index" + index + "Invalid index");
        }
         buffer[index] = element;
    } 
/**
 * Throws an EmptyCollectionException if necessary.
 * @throws EmptyCollectionException if an ArrayList is empty
 * @param ece an EmptyCollectionException to throw if necessary 
 */
private void throwECEIfNecessary(EmptyCollectionException ece) throws EmptyCollectionException{
    if (isEmpty()){
        throw new EmptyCollectionException("ArrayList is empty ");
    }
}

        /**
    * Checks if resizing is needed and resizes the buffer if necessary.
    *
    */
   private void resizeIfNeeded(){
   if (size == capacity){
        capacity = capacity * 2;
        buffer = Arrays.copyOf(buffer,capacity * 2); 
    }
}
    /**
     * Shifts the elements of the array to the left
     * 
     * Note: this method does decrement the size of the ArrayList
     * Note: It sets the last element to null 
     * @param index the index to start shifting from 
     */
    private void shiftLeft(int index){
        for (int i = index; i < size; i++){
            buffer[i-1] = buffer[i]; 
        }

        buffer[size - 1] = null;
        size = size - 1; 
    }

    /**
     * Shifts all elements to the right, starting from the specified element
     * <ul>
     * <li> Note: this method does increment the size of t ArrayList
     * <li> Note: It sets the first element to null
     * <li> Note: It resizes the array list if needed
     * </ul>
     * @param index the index to start shifting from 
     */
    private void shiftRight(int index){

        resizeIfNeeded();
        for (int i = size - 1; i >= index; i--){
            buffer[i + 1] = buffer[i]; 
        }

        buffer[index] = null;
        size = size + 1; 
    }
        

     

    public static void main(String[] args) throws EmptyCollectionException {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("List is" + list);
        list.removeLast();
        System.out.println("After removing last element, list is" + list);
        list.removeFirst();
        System.out.println("After removing first element, list is" + list);
        list.addFirst(6);
        System.out.println("After adding 6 to the front, list is" + list);
    }
}
