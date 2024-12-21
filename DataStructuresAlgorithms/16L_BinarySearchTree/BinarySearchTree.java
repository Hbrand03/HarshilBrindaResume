package DataStructures;

import java.util.ArrayList;

import ADTs.BinarySearchTreeADT;
import Exceptions.EmptyTreeException;
import Exceptions.NodeNotFoundException;

/**
 * An implementation of a binary search tree.
 */
public class BinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
  /**
   * The root node of the binary search tree.
   */
  TreeNode<E> root = null;

  /**
   * The number of nodes in the binary search tree.
   */
  int size = 0;

  /**
   * Constructs an empty binary search tree.
   */
  public BinarySearchTree() {
    root = null;
  }

  /**
   * Returns true if the tree is empty.
   *
   * @return true if the tree is empty, false otherwise
   */
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * Returns the size of the binary search tree by recursively counting the number of nodes.
   *
   * @return the number of nodes in the binary search tree
   */
  public int size() {
    return size(root,0);
  }

  /**
   * Calculates the size of a binary search tree recursively by counting the number of nodes.
   *
   * @param  node         the root node of the binary search tree
   * @param  runningCount the running count of nodes encountered so far
   * @return              the total number of nodes in the binary search tree
   */
  private int size(TreeNode<E> node, int runningCount) {
    if (node == null) {
      return runningCount;
    } else {
      runningCount = size(node.getLeft(), runningCount);
      runningCount++; 
      runningCount = size(node.getRight(), runningCount);
      return runningCount;
    }
  }

  /**
   * Inserts an element into the binary search tree.
   *
   * @param  element  the element to be inserted
   */
  public void insert(E element) {
    if(root == null) {
      root = new TreeNode<E>(element);
    } else {
      insert(root,element);
    }
    
  }

  /**
   * Inserts a new node into the binary search tree.
   *
   * @param  node        the current node being compared
   * @param  element     the element to be inserted
   */
  public void insert(TreeNode<E> node, E element) {
    
      int compareResult = element.compareTo(node.getElement());
      if(compareResult > 0){
       if(node.getRight() == null) {
         node.setRight(new TreeNode<E>(element));
       } else {
         insert(node.getRight(),element);
       }
      } else {
       if(node.getLeft() == null) {
         node.setLeft(new TreeNode<E>(element));
       } else {
         insert(node.getLeft(),element);
       }
      }
    }
  

  /**
   * Checks if the binary search tree contains a given element.
   *
   * @param  element  the element to search for
   * @return          true if the element is found, false otherwise
   * @throws EmptyTreeException if the tree is empty
   * @throws NodeNotFoundException if the element is not found in the tree
   */
  public boolean contains(E element) throws EmptyTreeException {
    try{
      search(element);
      return true;
    } catch (NodeNotFoundException e) {
      return false;
    } 
  }

  /**
   * Searches for an element in the binary search tree.
   *
   * @param  element  the element to search for
   * @return          the element if found, throws NodeNotFoundException if not found
   * @throws EmptyTreeException if the tree is empty
   * @throws NodeNotFoundException if the element is not found in the tree
   */
  public E search(E element) throws NodeNotFoundException, EmptyTreeException {
    if(root == null) {
      throw new EmptyTreeException("The tree is empty");
    } else if(root.getElement().compareTo(element) == 0) {
      return root.getElement();
    } else {
      return search(root, element);
    }
  }

  /**
   * Searches for an element in a binary search tree recursively.
   *
   * @param  node   the current node being compared
   * @param  element the element to search for
   * @return        the element if found, throws NodeNotFoundException if not found
   */
  public E search(TreeNode<E> node, E element) {
    if(node == null){
      throw new NodeNotFoundException();
    } else if(node.getElement().compareTo(element) == 0) {
      return node.getElement();
    } else if(node.getElement().compareTo(element) > 0) {
      return search(node.getLeft(), element);
    } else {
      return search(node.getRight(), element);
    }
  }

  /**
   * Traverses the binary search tree in pre-order and returns a string representation of the traversed elements.
   *
   * @return  a string representation of the traversed elements in pre-order
   */
  public String preOrder() {
    ArrayList<E> traversedElements = new ArrayList<E>();
    traversedElements = preOrder(root, traversedElements);
    return traversedElements.toString();
  }

  /**
   * Traverses the binary search tree in pre-order and returns a list of visited elements.
   *
   * @param  node                        the current node being visited
   * @param  runningListOfVistedNodes   the list of visited elements so far
   * @return                             the list of visited elements after traversing the tree
   */
  public ArrayList<E> preOrder(TreeNode<E> node, ArrayList<E> runningListOfVistedNodes) {
    if(node == null){
      return runningListOfVistedNodes;
    } else {

      runningListOfVistedNodes.add(node.getElement());
      runningListOfVistedNodes = preOrder(node.getLeft(), runningListOfVistedNodes);
      runningListOfVistedNodes =preOrder(node.getRight(), runningListOfVistedNodes);
      

      return runningListOfVistedNodes;
    }
  }

  /**
   * Traverses the binary search tree in post-order and returns a string representation of the traversed elements.
   *
   * @return  a string representation of the traversed elements in post-order
   */
  public String postOrder() {
    ArrayList<E> traversedElements = new ArrayList<E>();
    traversedElements = postOrder(root, traversedElements);
    return traversedElements.toString();
  }

/**
 * Traverses the binary search tree in post-order and returns a list of visited elements.
 *
 * @param  node                    the root node of the binary search tree
 * @param  runningListOfVistedNodes the list of visited elements encountered so far
 * @return                         the list of visited elements in post-order
 */
  public ArrayList<E> postOrder(TreeNode<E> node, ArrayList<E> runningListOfVistedNodes) {
    if(node == null){
      return runningListOfVistedNodes;
    } else {
      
      runningListOfVistedNodes = postOrder(node.getLeft(), runningListOfVistedNodes);
      runningListOfVistedNodes =postOrder(node.getRight(), runningListOfVistedNodes);
      runningListOfVistedNodes.add(node.getElement());

      return runningListOfVistedNodes;
    }
  }

  /**
   * Performs an in-order traversal of the binary search tree.
   *
   * @return          a string representation of the elements traversed in-order
   */
  public String inOrder() {
    ArrayList<E> traversedElements = new ArrayList<E>();
    traversedElements = inOrder(root, traversedElements);
    return traversedElements.toString();
  }

/**
 * Performs an in-order traversal of a binary search tree and returns a list of visited elements.
 *
 * @param  node           the root node of the binary search tree
 * @param  runningListOfVistedNodes  the list of visited elements
 * @return                 the list of visited elements in in-order traversal
 */
  public ArrayList<E> inOrder(TreeNode<E> node, ArrayList<E> runningListOfVistedNodes) {
    if(node == null){
      return runningListOfVistedNodes;
    } else {
      
      runningListOfVistedNodes = inOrder(node.getLeft(), runningListOfVistedNodes);
      runningListOfVistedNodes.add(node.getElement());
      runningListOfVistedNodes =inOrder(node.getRight(), runningListOfVistedNodes);
      

      return runningListOfVistedNodes;
    }
  }

  /**
   * Deletes an element from the tree.
   * 
   * @param element the element to be deleted.
   * @throws EmptyTreeException if the tree is empty and no elements can be
   *                            deleted.
   */
  public void delete(E element) throws EmptyTreeException {
    // Check if the tree is empty
    if (root == null) {
      throw new EmptyTreeException();
    }

    // Call the recursive helper method starting from the root
    root = delete(root, element);
  }

  /**
   * Deletes a node from the binary search tree with the given element.
   *
   * @param  node     the current node being considered for deletion
   * @param  element  the element to be deleted from the tree
   * @return          the updated node after deletion
   */
  private TreeNode<E> delete(TreeNode<E> node, E element) {
    // Base case: if the node is null, return null
    if (node == null) {
      return null;
    }

    // Compare the element with the node's element
    int comparison = element.compareTo(node.getElement());

    // If the element is smaller than the node's element, go to the left subtree
    if (comparison < 0) {
      node.setLeft(delete(node.getLeft(), element));
    }
    // If the element is greater than the node's element, go to the right subtree
    else if (comparison > 0) {
      node.setRight(delete(node.getRight(), element));
    }
    // If the element is equal to the node's element, delete the node
    else {
      // Case 1: the node has no children, return null
      if (node.getLeft() == null && node.getRight() == null) {
        return null;
      }
      // Case 2: the node has only one child, return that child
      else if (node.getLeft() == null) {
        return node.getRight();
      } else if (node.getRight() == null) {
        return node.getLeft();
      }
      // Case 3: the node has two children, replace it with its in-order successor
      else {
        // Find the smallest node in the right subtree
        TreeNode<E> successor = findMin(node.getRight());

        // Copy its element to the current node
        node.setElement(successor.getElement());

        // Delete the successor from the right subtree
        node.setRight(delete(node.getRight(), successor.getElement()));
      }
    }

    // Return the updated node
    return node;
  }

  
  /**
   * Finds the smallest node in a subtree.
   *
   * @param  node  the root node of the subtree
   * @return       the smallest node in the subtree
   */
  private TreeNode<E> findMin(TreeNode<E> node) {
    // Base case: if the node has no left child, return it
    if (node.getLeft() == null) {
      return node;
    }

    // Recursive case: go to the left subtree
    return findMin(node.getLeft());
  }

}
