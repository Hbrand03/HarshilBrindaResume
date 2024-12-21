package ADTs;

public interface VertexADT<T extends Comparable<T>> extends Comparable<VertexADT<T>> {
  /**
   * Returns the data stored in the vertex.
   *
   * @return the data stored in the vertex
   */
  public T getData();

  /**
   * Sets the data stored in the vertex.
   *
   * @param data the new data to be stored in the vertex
   */
  public void setData(T data);

  /**
   * Compares the data stored in the vertex to the data stored in another vertex.
   * 
   * @param other the other vertex to be compared
   * @return a negative integer, zero, or a positive integer if the data stored in
   *         this vertex is less than, equal to, or greater than the data stored
   *         in the other vertex
   */
  public int compareTo(VertexADT<T> other);
}