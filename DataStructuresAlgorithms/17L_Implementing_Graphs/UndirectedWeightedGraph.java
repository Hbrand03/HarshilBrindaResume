package DataStructures;

import java.util.HashSet;
import java.util.Set;

import ADTs.GraphADT;

/**
 * A class representing an undirected weighted graph.
 *
 * @param <T> the type of elements stored in the graph's vertices, which must be
 *            comparable
 * @param <W> the type of weight stored in the graph's edges
 */
public class UndirectedWeightedGraph<T extends Comparable<T>, W extends Comparable<W>>
    implements GraphADT<T, Vertex<T>, UndirectedWeightedEdge<T, W>> {

  /** The set of vertices in the graph. */
  Set<Vertex<T>> vertices;

  /** The set of edges in the graph. */
  Set<UndirectedWeightedEdge<T, W>> edges;

  /**
   * Constructs an empty undirected weighted graph.
   */
  public UndirectedWeightedGraph() {
    vertices = new HashSet<>();
    edges = new HashSet<>();
  }

  /**
   * Adds the specified vertex to the graph.
   *
   * @param vertex the vertex to be added to the graph
   * @return true if the vertex was added successfully, false otherwise (e.g., if
   *         the vertex already
   *         exists in the graph)
   */
  public boolean addVertex(Vertex<T> vertex) {
    return vertices.add(vertex);
  }

  /**
   * Removes the specified vertex from the graph, along with any edges that are
   * incident to it.
   *
   * @param vertex the vertex to be removed from the graph
   * @return true if the vertex was removed successfully, false otherwise (e.g.,
   *         if the vertex does
   *         not exist in the graph)
   */
  public boolean removeVertex(Vertex<T> vertex) {
    return vertices.remove(vertex);
  }

  /**
   * Returns the vertex in the graph with the specified data.
   *
   * @param data the data associated with the vertex to be returned
   * @return the vertex in the graph with the specified data, or null if no such
   *         vertex exists in
   *         the graph
   */
  public Vertex<T> getVertex(T data) {
    for (Vertex<T> vertex : vertices) {
      if (vertex.getData().equals(data)) {
        return vertex;
      }
    }
    return null;
  }

  /**
   * Adds an edge between the specified vertices with the given weight to the
   * graph.
   *
   * @param first  one of the vertices that the edge connects
   * @param second the other vertex that the edge connects
   * @param weight the weight of the edge
   * @return true if the edge was added successfully, false otherwise (e.g., if
   *         either vertex does
   *         not exist in the graph or if the two vertices are the same)
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second, W weight) {
    if(first == null || second == null) {
      return false;
    }
    if(first.compareTo(second) == 0) {
      return false;
    }
    if(vertices.contains(first) && vertices.contains(second)) {
      UndirectedWeightedEdge<T, W> edge = new UndirectedWeightedEdge<>(first, second, weight);
    return edges.add(edge);
    } else {
      return false;
    }
  }

  /**
   * Removes the edge between the specified vertices from the graph.
   *
   * @param first  one of the vertices that the edge connects
   * @param second the other vertex that the edge connects
   * @return true if the edge was removed successfully, false otherwise (e.g., if
   *         the two vertices
   *         are the same or if there is no edge between them in the graph)
   */
  public boolean removeEdge(Vertex<T> first, Vertex<T> second) {
    UndirectedWeightedEdge<T, W> edgeToRemove = null;
    for (UndirectedWeightedEdge<T, W> edge : edges) {
      if ((edge.getFirstVertex().equals(first) && edge.getSecondVertex().equals(second)) || 
          (edge.getFirstVertex().equals(second) && edge.getSecondVertex().equals(first))) {
          edgeToRemove = edge;
          break;
      }
  }
  
  if (edgeToRemove != null) {
      edges.remove(edgeToRemove);
      return true;
  } else {
      return false; // Edge not found in the graph
  }
  }

  /**
   * Returns the number of vertices in the graph.
   *
   * @return the number of vertices in the graph
   */
  public int getVertexCount() {
    return vertices.size();
  }

  /**
   * Returns the number of edges in the graph.
   *
   * @return the number of edges in the graph
   */
  public int getEdgeCount() {
    return edges.size();
  }

  /**
   * Returns an iterable collection of all vertices in the graph.
   *
   * @return an iterable collection of all vertices in the graph
   */
  public Iterable<Vertex<T>> getVertices() {
    return vertices;
  }

  /**
   * Returns an iterable collection of all edges in the graph.
   *
   * @return an iterable collection of all edges in the graph
   */
  public Iterable<UndirectedWeightedEdge<T, W>> getEdges() {
    return edges;
  }

  /**
   * Returns an iterable collection of all edges in the graph that are adjacent to
   * the specified
   * vertex.
   *
   * @param vertex the vertex whose adjacent edges are to be returned
   * @return an iterable collection of all edges in the graph that are adjacent to
   *         the specified
   *         vertex
   */
  public Iterable<UndirectedWeightedEdge<T, W>> getAdjacentEdges(Vertex<T> vertex) {
    Set<UndirectedWeightedEdge<T, W>> adjacentEdges = new HashSet<>();

    for (UndirectedWeightedEdge<T, W> edge : edges) {
      if (edge.getFirstVertex().compareTo(vertex) == 0 || edge.getSecondVertex().compareTo(vertex) == 0) {
        adjacentEdges.add(edge);
      }
    }

    return adjacentEdges;
  }

  /**
   * Adds an unweighted edge between the specified vertices to the graph. This
   * method always throws
   * an IllegalArgumentException because it is not possible to add an unweighted
   * edge to a weighted
   * graph.
   *
   * @param first  one of the vertices that the edge connects
   * @param second the other vertex that the edge connects
   * @return never returns a value because an exception is always thrown
   * @throws IllegalArgumentException always thrown because this method does not
   *                                  allow unweighted
   *                                  edges to be added to the graph
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second) {
    throw new IllegalArgumentException(
        "Please provide a weight for the edge by using addEdge(Vertex<T> first, Vertex<T> second, W weight)");
  }

  @Override
  /**
   * Returns a string representation of the graph.
   */
  public String toString() {
    return "UndirectedWeightedGraph [vertices=" + vertices + ", edges=" + edges + "]";
  }
}
