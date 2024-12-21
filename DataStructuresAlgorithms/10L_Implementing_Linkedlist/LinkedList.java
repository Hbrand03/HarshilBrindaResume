package DataStructures;

import Exceptions.*;

import ADTs.*;

/**
 * An implementation of the ADT List using a singly linked list
 */
public class LinkedList<T extends Comparable<T>> implements ListADT<T> {
    /**
     * The head of the linked list
     */
    SinglyLinkedNode<T> head;
    /**
     * The number of elements in the linked list
     */
    int size;
    /**
     * Constructor for the linked list
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
    /**
     * Check if the linked list is empty.
     *
     * @return         true if the linked list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * A description of the entire Java function.
     * @return size returns the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds the specified element to the beginning of the list.
     *
     * @param  element   the element to add to the beginning of the list
     */
    @Override
    public void addFirst(T element) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<T>(element);
        if(isEmpty()){
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param  element  the element to be added to the list
     */
    @Override
    public void addLast(T element) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<T>(element);
        if(isEmpty()){
            head = newNode;
        } else {
            SinglyLinkedNode<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Adds an element after a specified existing element in the collection.
     *
     * @param  existing  the existing element after which to add the new element
     * @param  element   the new element to add
     * @throws ElementNotFoundException   if the existing element is not found
     * @throws EmptyCollectionException   if the collection is empty
     */
    @Override
    public void addAfter(T existing, T element) throws ElementNotFoundException, EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        int index = indexOf(existing);
        if(index == -1){
            throw new ElementNotFoundException(element.toString());
        }
        int i = 0;
        SinglyLinkedNode<T> nodeToInsertAfter = head;

        while(i < index){
            nodeToInsertAfter = nodeToInsertAfter.getNext();
            i++;
        }
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<T>(element);
        newNode.setNext(nodeToInsertAfter.getNext());
        nodeToInsertAfter.setNext(newNode);
        size++;
    }

    /**
     * Remove the specified element from the collection.
     *
     * @param  element  the element to be removed
     * @return          the removed element
     * @throws EmptyCollectionException   if the collection is empty
     * @throws ElementNotFoundException    if the element is not found in the collection
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        int index = indexOf(element);
        if(index == -1){
            throw new ElementNotFoundException(element.toString());
        }

        if(index == 0){
            return removeFirst();
        } else if (index == size - 1){
            return removeLast();
        } else {
            int i = 0;
            SinglyLinkedNode<T> curNode = head;
            while(i < index){
                curNode = curNode.getNext();
                i++;
            }
            T result = curNode.getNext().getData();
            curNode.setNext(curNode.getNext().getNext());
            size--;
            return result;
        }
    }

    /**
     * Removes and returns the first element of the collection.
     *
     * @return          the first element of the collection
     * @throws EmptyCollectionException if the collection is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        T result = head.getData();
        head = head.getNext();
        size--;
        return result;
    }

    /**
     * Removes the last element from the collection.
     *
     * @return         	the removed element
     * @throws EmptyCollectionException	if the collection is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        T result = null;
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        if(size == 1){
            return removeFirst();
        } else {
            SinglyLinkedNode<T> i = head;
            while(i.getNext().getNext() != null){
                i = i.getNext();
            }
            result = i.getNext().getData();
            i.setNext(null);
            size--;
            return result;
        }
        

    }

    /**
     * Returns the first element in the collection.
     *
     * @return         	the first element in the collection
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException();
        }
        return head.getData();
    }

    /**
     * Returns the last element in the collection.
     *
     * @return          the last element in the collection
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException();
        }
        SinglyLinkedNode<T> i = head;
        while(i.getNext() != null){
            i = i.getNext();
        }
        return i.getData();
    }

    /**
     * Check if the collection contains a specific element.
     *
     * @param  element  the element to check for in the collection
     * @return          true if the element is found, false otherwise
     */
    @Override
    public boolean contains(T element) throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException();
        }
        return indexOf(element) != -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
     *
     * @param  element  the element to search for
     * @return          the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(T element) {
        SinglyLinkedNode<T> i = head;
        int index = 0;
        while(i != null){
            if(i.getData().compareTo(element) == 0){
                return index;
            }
            index++;
            i = i.getNext();
        }
        return -1;
    }

    /**
     * A description of the entire Java function.
     *
     * @param  index      description of parameter
     * @return         	description of return value
     */
    @Override
    public T get(int index) throws EmptyCollectionException, InvalidArgumentException {
        if (isEmpty()){
            throw new EmptyCollectionException();
        }
        if(index < 0 || index >= size){
            throw new InvalidArgumentException();
        }
        int i = 0;
        SinglyLinkedNode<T> iNode = head;
        while(i < index){
            iNode = iNode.getNext();
            i++;
        }
        return iNode.getData();
    }

    /**
     * A description of the entire Java function.
     *
     * @param  index       description of parameter
     * @param  element     description of parameter
     * @throws EmptyCollectionException	description of parameter
     * @throws InvalidArgumentException	description of parameter
     */
    @Override
    public void set(int index, T element) throws EmptyCollectionException, InvalidArgumentException {
        if (isEmpty()){
            throw new EmptyCollectionException();
        }
        if(index < 0 || index >= size){
            throw new InvalidArgumentException();
        }
        int i = 0;
        SinglyLinkedNode<T> nodeAtIndex = head;
        while(i < index){
            nodeAtIndex = nodeAtIndex.getNext();
            i++;
        }
        nodeAtIndex.setData(element);
    }

}