package ADTs;

import Exceptions.*;

/**
 * An abstract data type for a binary search tree.
 * 
 * @param <E> the type of elements in the tree, which must implement the
 *            Comparable interface.
 */
public interface BinarySearchTreeADT<E extends Comparable<E>> extends CollectionADT<E> {

  /**
   * Inserts an element into the tree.
   * 
   * @param element the element to be inserted.
   */
  public void insert(E element);

  /**
   * Searches for an element in the tree.
   * 
   * @param element the element to search for.
   * @return true if the element is found in the tree, false otherwise.
   */
  public boolean contains(E element) throws EmptyTreeException;

  /**
   * Searches for an element in the tree.
   * 
   * @param element the element to search for.
   * @return the element if it is found in the tree.
   * @throws NodeNotFoundException if the element is not found in the tree.
   */
  public E search(E element) throws NodeNotFoundException, EmptyTreeException;

  /**
   * Deletes an element from the tree.
   * 
   * @param element the element to be deleted.
   * @throws EmptyTreeException if the tree is empty and no elements can be
   *                            deleted.
   */
  public void delete(E element) throws EmptyTreeException;

  /**
   * Traverses the tree in in-order.
   */
  public String inOrder();

  /**
   * Traverses the tree in pre-order.
   */
  public String preOrder();

  /**
   * Traverses the tree in post-order.
   */
  public String postOrder();
}
