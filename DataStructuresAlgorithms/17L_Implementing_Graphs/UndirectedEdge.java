package DataStructures;

import ADTs.EdgeADT;

/**
 * An undirected, unweighted edge between two vertices in a graph.
 * 
 * @param <T> the type of the data in the vertices
 * @param <V> the type of the vertices
 */
public class UndirectedEdge<T extends Comparable<T>> implements EdgeADT<T, Vertex<T>> {
  /** The first vertex */
  private Vertex<T> firstVertex;
  /** The second vertex */
  private Vertex<T> secondVertex;

  /**
   * Creates an undirected, unweighted edge between the given vertices.
   * 
   * @param firstVertex  the first vertex
   * @param secondVertex the second vertex
   */
  public UndirectedEdge(Vertex<T> firstVertex, Vertex<T> secondVertex) {
    this.firstVertex = firstVertex;
    this.secondVertex = secondVertex;
  }

  /**
   * Returns the first vertex of this edge.
   * 
   * @return the first vertex of this edge
   */
  public Vertex<T> getFirstVertex() {
    return firstVertex;
  }

  /**
   * Returns the second vertex of this edge.
   * 
   * @return the second vertex of this edge
   */
  public Vertex<T> getSecondVertex() {
    return secondVertex;
  }

  /**
   * Returns false for an undirected edge.
   * 
   * @return false
   */
  public boolean isDirected() {
    return false;
  }

  /**
   * Returns false for an unweighted edge.
   * 
   * @return false
   */
  public boolean isWeighted() {
    return false;
  }

  /**
   * Returns an integer representing the order of this edge relative to the given
   * edge. Returns 0 if
   * the edges are equal, -1 if this edge is less than the given edge, and 1 if
   * this edge is greater.
   * 
   * @param other the edge to compare to
   */
  public int compareTo(EdgeADT<T, Vertex<T>> other) {
    if (this.equals(other)) {
      return 0;
    } else if (!other.isDirected() && !other.isWeighted()) {
      if (this.firstVertex.compareTo(other.getFirstVertex()) == 0
          && this.secondVertex.compareTo(other.getSecondVertex()) == 0 ||
          this.firstVertex.compareTo(other.getSecondVertex()) == 0
              && this.secondVertex.compareTo(other.getFirstVertex()) == 0) {
        return 0;
      } else if (this.firstVertex.compareTo(other.getFirstVertex()) < 0
          || this.firstVertex.compareTo(other.getFirstVertex()) == 0
              && this.secondVertex.compareTo(other.getSecondVertex()) < 0) {
        return -1;
      } else {
        return 1;
      }
    } else {
      throw new IllegalArgumentException("Can only compare undirected, unweighted edges.");
    }
  }

  @Override
  /**
   * Returns a hash code for this edge.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstVertex == null) ? 0 : firstVertex.hashCode());
    result = prime * result + ((secondVertex == null) ? 0 : secondVertex.hashCode());
    return result;
  }

  @Override
  /**
   * Returns true if this edge is equal to the given object.
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
    UndirectedEdge<T> other = (UndirectedEdge<T>) obj;
    if (firstVertex == null) {
      if (other.firstVertex != null) {
        return false;
      }
    } else if (!firstVertex.equals(other.firstVertex)) {
      return false;
    }
    if (secondVertex == null) {
      if (other.secondVertex != null) {
        return false;
      }
    } else if (!secondVertex.equals(other.secondVertex)) {
      return false;
    }
    return true;
  }

  @Override
  /**
   * Returns a string representation of this edge.
   */
  public String toString() {
    return "UndirectedEdge [firstVertex=" + firstVertex + ", secondVertex=" + secondVertex + "]";
  }
}
