package DataStructures;

import ADTs.EdgeADT;

/**
 * A directed, unweighted edge between two vertices in a graph.
 * 
 * @param <V> the type of the vertices
 */
public class DirectedEdge<T extends Comparable<T>> implements EdgeADT<T, Vertex<T>> {

  /** The source vertex. */
  private Vertex<T> sourceVertex;
  /** The destination vertex. */
  private Vertex<T> destinationVertex;

  /**
   * Creates a directed, unweighted edge between the given vertices.
   * 
   * @param sourceVertex      the source vertex
   * @param destinationVertex the destination vertex
   */
  public DirectedEdge(Vertex<T> source, Vertex<T> destination) {
    this.sourceVertex = source;
    this.destinationVertex = destination;
  }

  /**
   * Returns the source vertex.
   */
  public Vertex<T> getFirstVertex() {
    return sourceVertex;
  }

  /**
   * Returns the destination vertex.
   */
  public Vertex<T> getSecondVertex() {
    return destinationVertex;
  }

  /**
   * Always true for a directed edge.
   */
  public boolean isDirected() {
    return true;
  }

  /**
   * Always false for a unweighted edge.
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
    } else if (other.isDirected() && !other.isWeighted()) {
      if (other.getFirstVertex().getData().compareTo(sourceVertex.getData()) == 0
          && other.getSecondVertex().getData().compareTo(destinationVertex.getData()) == 0) {
        return 0;
      } else {
        return -1;
      }
    } else {
      throw new IllegalArgumentException("Can only compare to a directed, unweighted edge.");
    }
  }

  @Override
  /**
   * Returns the hash code of the source and destination vertices.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((sourceVertex == null) ? 0 : sourceVertex.hashCode());
    result = prime * result + ((destinationVertex == null) ? 0 : destinationVertex.hashCode());
    return result;
  }

  @Override
  /**
   * Returns true if the source and destination vertices are equal to the source.
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
    DirectedEdge<T> other = (DirectedEdge<T>) obj;

    if (sourceVertex == null) {
      if (other.sourceVertex != null) {
        return false;
      }
    } else if (!sourceVertex.equals(other.sourceVertex)) {
      return false;
    }
    if (destinationVertex == null) {
      if (other.destinationVertex != null) {
        return false;
      }
    } else if (!destinationVertex.equals(other.destinationVertex)) {
      return false;
    }
    return true;
  }

  @Override
  /**
   * Returns a string representation of the edge.
   */
  public String toString() {
    return "DirectedEdge [sourceVertex=" + sourceVertex + ", destinationVertex=" + destinationVertex + "]";
  }
}
