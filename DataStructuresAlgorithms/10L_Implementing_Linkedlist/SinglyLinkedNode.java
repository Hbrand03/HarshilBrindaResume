package DataStructures;

/**
 * Represents a node in a singly linked list.
 *
 * @param <T> the type of data stored in the node
 */
public class SinglyLinkedNode<T> {
  private T data;
  private SinglyLinkedNode<T> next;

  /**
   * Constructs a new SinglyLinkedNode with the specified data.
   *
   * @param data the data to be stored in the node
   */
  public SinglyLinkedNode(T data) {
    this.data = data;
    next = null;
  }

  /**
   * Retrieves the data stored in the node.
   *
   * @return the data stored in the node
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data to be stored in the node.
   *
   * @param data the data to be stored in the node
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Retrieves the next node in the linked list.
   *
   * @return the next node in the linked list
   */
  public SinglyLinkedNode<T> getNext() {
    return next;
  }

  /**
   * Sets the next node in the linked list.
   *
   * @param next the next node in the linked list
   */
  public void setNext(SinglyLinkedNode<T> next) {
    this.next = next;
  }
}
