package DataStructures;

/**
 * A class for a node in a binary search tree
 * 
 * @param <E> the type of element stored in this node
 */
public class TreeNode<E extends Comparable<E>> {

  // The element stored in this node
  private E element;

  // The left child of this node
  private TreeNode<E> left;

  // The right child of this node
  private TreeNode<E> right;

  /**
   * Constructs a new node with the given element and no children
   * 
   * @param element the element to be stored in this node
   */
  public TreeNode(E element) {
    this.element = element;
    this.left = null;
    this.right = null;
  }

  /**
   * Returns the element stored in this node
   * 
   * @return the element stored in this node
   */
  public E getElement() {
    return element;
  }

  /**
   * Sets the element stored in this node
   * 
   * @param element the new element to be stored in this node
   */
  public void setElement(E element) {
    this.element = element;
  }

  /**
   * Returns the left child of this node
   * 
   * @return the left child of this node
   */
  public TreeNode<E> getLeft() {
    return left;
  }

  /**
   * Sets the left child of this node
   * 
   * @param left the new left child of this node
   */
  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  /**
   * Returns the right child of this node
   * 
   * @return the right child of this node
   */
  public TreeNode<E> getRight() {
    return right;
  }

  /**
   * Sets the right child of this node
   * 
   * @param right the new right child of this node
   */
  public void setRight(TreeNode<E> right) {
    this.right = right;
  }
}
