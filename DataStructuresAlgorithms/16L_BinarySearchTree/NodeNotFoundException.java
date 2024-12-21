package Exceptions;

/**
 * A class for an exception that occurs when the node is not found.
 */
public class NodeNotFoundException extends RuntimeException {

  /**
   * Constructs a new exception with the default message: "The node is not found."
   */
  public NodeNotFoundException() {
    super("The node is not found.");
  }

  /**
   * Constructs a new exception with the given message.
   * 
   * @param message the message to be displayed when the exception is thrown.
   */
  public NodeNotFoundException(String message) {
    super(message);
  }
}
