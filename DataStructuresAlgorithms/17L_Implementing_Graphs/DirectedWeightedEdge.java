package DataStructures;

import ADTs.EdgeADT;

/**
 * A directed, weighted edge between two vertices in a graph.
 *
 * @param <T> the type of the data in the vertices
 */
public class DirectedWeightedEdge<T extends Comparable<T>, W extends Comparable<W>> implements EdgeADT<T, Vertex<T>> {

  /** The source vertex */
  private Vertex<T> sourceVertex;
  /** The destination vertex */
  private Vertex<T> destinationVertex;
  /** The weight of the edge */
  private W weight;

  /**
   * Creates a directed, weighted edge between the given vertices with the given
   * weight.
   *
   * @param sourceVertex      the source vertex
   * @param destinationVertex the destination vertex
   * @param weight            the weight of the edge
   */
  public DirectedWeightedEdge(Vertex<T> sourceVertex, Vertex<T> destinationVertex, W weight) {
    this.sourceVertex = sourceVertex;
    this.destinationVertex = destinationVertex;
    this.weight = weight;
  }

  /**
   * Returns the source vertex of this directed edge.
   *
   * @return the source vertex of this directed edge
   */
  public Vertex<T> getFirstVertex() {
    return sourceVertex;
  }

  /**
   * Returns the destination vertex of this directed edge.
   *
   * @return the destination vertex of this directed edge
   */
  public Vertex<T> getSecondVertex() {
    return destinationVertex;
  }

  /**
   * Returns true for a directed edge.
   *
   * @return true for a directed edge
   */
  public boolean isDirected() {
    return true;
  }

  /**
   * Returns true for a weighted edge.
   *
   * @return true for a weighted edge
   */
  public boolean isWeighted() {
    return true;
  }

  /**
   * Returns the weight of the edge.
   *
   * @return the weight of the edge
   */
  public W getWeight() {
    return weight;
  }

  /**
   * Sets the weight of the edge.
   *
   * @param weight the weight of the edge
   */
  public void setWeight(W weight) {
    this.weight = weight;
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
    } else if (other.isWeighted() && other.isDirected()) {
      DirectedWeightedEdge<T, W> otherEdge = (DirectedWeightedEdge<T, W>) other;

      if (this.sourceVertex.compareTo(other.getFirstVertex()) == 0
          && this.destinationVertex.compareTo(other.getSecondVertex()) == 0) {
        return this.weight.compareTo(otherEdge.getWeight());
      } else if (this.sourceVertex.compareTo(other.getFirstVertex()) == 0) {
        return this.destinationVertex.compareTo(other.getSecondVertex());
      } else {
        return this.sourceVertex.compareTo(other.getFirstVertex());
      }
    } else {
      throw new IllegalArgumentException("Can only compare to another directed, weighted edge.");
    }
  }

  @Override
  /**
   * Returns a hash code for this edge.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((sourceVertex == null) ? 0 : sourceVertex.hashCode());
    result = prime * result + ((destinationVertex == null) ? 0 : destinationVertex.hashCode());
    result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
    DirectedWeightedEdge<T, W> other = (DirectedWeightedEdge<T, W>) obj;
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
    if (weight == null) {
      if (other.weight != null) {
        return false;
      }
    } else if (!weight.equals(other.weight)) {
      return false;
    }
    return true;
  }

  @Override
  /**
   * Returns a string representation of this edge.
   */
  public String toString() {
    return "DirectedWeightedEdge [sourceVertex=" + sourceVertex + ", destinationVertex=" + destinationVertex
        + ", weight=" + weight + "]";
  }
}
