package DataStructures;

import ADTs.VertexADT;

/**
 * A vertex in a graph.
 * 
 * @param <T> the type of the data in the vertex
 */
public class Vertex<T extends Comparable<T>> implements VertexADT<T> {
  /** inner data */
  private T data;

  /**
   * Creates a vertex with the given data.
   * 
   * @param data the data to be stored in the vertex
   */
  public Vertex(T data) {
    this.data = data;
  }

  /**
   * Returns the data stored in the vertex.
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data stored in the vertex.
   */
  public void setData(T data) {
    this.data = data;
  }

  /*
   * Compares the data stored in the vertex to the data stored in another vertex.
   */
  public int compareTo(VertexADT<T> other) {
    return data.compareTo(other.getData());
  }

  @Override
  /**
   * Returns the hash code of the data stored in the vertex.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    return result;
  }

  @Override
  /**
   * Returns true if the data stored in the vertex is equal to the data stored in
   * another vertex.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vertex<T> other = (Vertex<T>) obj;

    if (data == null) {
      if (other.data != null) {
        return false;
      }
    } else if (data.compareTo(other.data) != 0) {
      return false;
    }
    return true;
  }

  @Override
  /**
   * Returns a string representation of the vertex.
   */
  public String toString() {
    return "Vertex [data=" + data + "]";
  }
}
