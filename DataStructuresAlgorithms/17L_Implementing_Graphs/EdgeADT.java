package ADTs;

public interface EdgeADT<T extends Comparable<T>, V extends VertexADT<T>> extends Comparable<EdgeADT<T, V>> {
  /**
   * Returns the first vertex of the edge.
   * 
   * @return the first vertex of the edge
   */
  public V getFirstVertex();

  /**
   * Returns the second vertex of the edge.
   * 
   * @return the second vertex of the edge
   */
  public V getSecondVertex();

  /**
   * Returns true if the edge is directed.
   * 
   * @return true if the edge is directed, false if not
   */
  public boolean isDirected();

  /**
   * Returns true if the edge is weighted.
   * 
   * @return true if the edge is weighted, false if not
   */
  public boolean isWeighted();
}