package DataStructures;

import ADTs.EdgeADT;

/**
 * An undirected, weighted edge in a graph.
 *
 * @param <T> the type of the data in the vertices
 * @param <V> the type of the vertices
 * @param <W> the type of the weight of the edge
 */
public class UndirectedWeightedEdge<T extends Comparable<T>, W extends Comparable<W>> implements EdgeADT<T, Vertex<T>> {
  /** The first vertex */
  private Vertex<T> firstVertex;
  /** The second vertex */
  private Vertex<T> secondVertex;
  /** The weight of the edge */
  private W weight;

  /**
   * Creates an undirected, weighted edge between the given vertices with the
   * given weight.
   *
   * @param firstVertex  the first vertex
   * @param secondVertex the second vertex
   * @param weight       the weight of the edge
   */
  public UndirectedWeightedEdge(Vertex<T> firstVertex, Vertex<T> secondVertex, W weight) {
    this.firstVertex = firstVertex;
    this.secondVertex = secondVertex;
    this.weight = weight;
  }

  /**
   * Returns the first vertex of the edge.
   *
   * @return the first vertex of the edge
   */
  public Vertex<T> getFirstVertex() {
    return firstVertex;
  }

  /**
   * Returns the second vertex of the edge.
   *
   * @return the second vertex of the edge
   */
  public Vertex<T> getSecondVertex() {
    return secondVertex;
  }

  /**
   * Returns true for an undirected edge.
   *
   * @return true
   */
  public boolean isDirected() {
    return false;
  }

  /**
   * Returns true for a weighted edge.
   *
   * @return true
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
    } else if (!other.isDirected() && other.isWeighted()) {
      UndirectedWeightedEdge<T, W> otherEdge = (UndirectedWeightedEdge<T, W>) other;

      if (this.firstVertex.compareTo(other.getFirstVertex()) == 0
          && this.secondVertex.compareTo(other.getSecondVertex()) == 0 ||
          this.firstVertex.compareTo(other.getSecondVertex()) == 0
              && this.secondVertex.compareTo(other.getFirstVertex()) == 0) {
        return this.weight.compareTo(otherEdge.getWeight());
      } else if (this.firstVertex.compareTo(other.getFirstVertex()) < 0
          || this.firstVertex.compareTo(other.getFirstVertex()) == 0
              && this.secondVertex.compareTo(other.getSecondVertex()) < 0) {
        return -1;
      } else {
        return 1;
      }
    } else {
      throw new IllegalArgumentException("Can only compare undirected, weighted edges.");
    }
  }

  @Override
  /**
   * Returns a HashCode for this edge.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstVertex == null) ? 0 : firstVertex.hashCode());
    result = prime * result + ((secondVertex == null) ? 0 : secondVertex.hashCode());
    result = prime * result + ((weight == null) ? 0 : weight.hashCode());
    return result;
  }

  @Override
  /**
   * Returns true if the given object is equal to this edge.
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
    UndirectedWeightedEdge<T, W> other = (UndirectedWeightedEdge<T, W>) obj;
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
    return "UndirectedWeightedEdge [firstVertex=" + firstVertex + ", secondVertex=" + secondVertex + ", weight="
        + weight + "]";
  }
}
