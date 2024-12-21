package Exceptions;

/**
 * A class for an exception that occurs when the tree is empty.
 */
public class EmptyTreeException extends RuntimeException {

  /**
   * Constructs a new exception with the default message: "The tree is empty."
   */
  public EmptyTreeException() {
    super("The tree is empty.");
  }

  /**
   * Constructs a new exception with the given message.
   * 
   * @param message the message to be displayed when the exception is thrown.
   */
  public EmptyTreeException(String message) {
    super(message);
  }
}
