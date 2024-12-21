package DataStructures;

import java.util.HashSet;
import java.util.Set;

import ADTs.GraphADT;

/**
 * A simple (meaning so self-loops), directed, weighted graph.
 * 
 * @param <T> the type of the data in the vertices
 * @param <W> the type of the weight of the edges
 */
public class DirectedWeightedGraph<T extends Comparable<T>, W extends Comparable<W>>
    implements GraphADT<T, Vertex<T>, DirectedWeightedEdge<T, W>> {

  /**
   * The set of vertices in the graph.
   */
  Set<Vertex<T>> vertices;

  /**
   * The set of directed, weighted edges in the graph.
   */
  Set<DirectedWeightedEdge<T, W>> edges;

  /**
   * Constructs a directed, weighted graph with no vertices or edges.
   */
  public DirectedWeightedGraph() {
    vertices = new HashSet<Vertex<T>>();
    edges = new HashSet<DirectedWeightedEdge<T, W>>();
  }

  /**
   * Adds a vertex to the graph.
   *
   * @param vertex the vertex to add
   * @return true if the vertex is added, false if it already exists in the graph
   */
  public boolean addVertex(Vertex<T> vertex) {
    return vertices.add(vertex);
  }

  /**
   * Removes a vertex from the graph. Also removes all edges adjacent to the
   * vertex.
   *
   * @param vertex the vertex to remove
   * @return true if the vertex is removed, false if it does not exist in the
   *         graph
   */
  public boolean removeVertex(Vertex<T> vertex) {
    return vertices.remove(vertex);
  }

  /**
   * Returns the vertex with the specified data, if it exists in the graph.
   *
   * @param data the data of the vertex to find
   * @return the vertex with the specified data, or null if it does not exist in
   *         the graph
   */
  public Vertex<T> getVertex(T data) {
    for (Vertex<T> vertex : vertices) {
      if (vertex.getData().compareTo(data) == 0) {
        return vertex;
      }
    }
    return null;
  }

  /**
   * Adds a directed weighted edge between the given vertices with the specified
   * weight to the graph.
   * 
   * @param first  the first vertex
   * @param second the second vertex
   * @param weight the weight of the edge
   * @return true if the edge is added, false if not
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second, W weight) {
     if(first == null || second == null ) {
       return false;
     } 

     if(first.compareTo(second) == 0) {
      return false;
    }
    if(vertices.contains(first) && vertices.contains(second)) {
      DirectedWeightedEdge<T, W> edge = new DirectedWeightedEdge<>(first, second, weight);
    return edges.add(edge);
    } else {
      return false;
    }
    
  }

  /**
   * Removes a directed weighted edge between the given vertices from the graph.
   * 
   * @param first  the first vertex
   * @param second the second vertex
   * @return true if the edge is removed, false if not
   */
  public boolean removeEdge(Vertex<T> first, Vertex<T> second) {
        DirectedWeightedEdge<T, W> edgeToRemove = null;
        for (DirectedWeightedEdge<T, W> edge : edges) {
            if (edge.getFirstVertex().compareTo(first) == 0 && edge.getSecondVertex().compareTo(second) == 0) {
                edgeToRemove = edge;
                break;
            }
        }
        if (edgeToRemove != null) {
            edges.remove(edgeToRemove);
            return true;
        } else {
            return false;
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
   * Returns an iterable collection of the vertices in the graph.
   * 
   * @return an iterable collection of the vertices in the graph
   */
  public Iterable<Vertex<T>> getVertices() {
    return vertices;
  }

  /**
   * Returns an iterable collection of the edges in the graph.
   * 
   * @return an iterable collection of the edges in the graph
   */
  public Iterable<DirectedWeightedEdge<T, W>> getEdges() {
    return edges;
  }

  /**
   * Returns an iterable collection of directed weighted edges that are adjacent
   * to the specified vertex.
   * 
   * @param vertex the vertex to get adjacent edges for
   * @return an iterable collection of directed weighted edges that are adjacent
   *         to the specified vertex
   * @throws NullPointerException if the vertex is null
   */
  public Iterable<DirectedWeightedEdge<T, W>> getAdjacentEdges(Vertex<T> vertex) {
    Set<DirectedWeightedEdge<T, W>> adjacentEdges = new HashSet<>();

    for (DirectedWeightedEdge<T, W> edge : edges) {
      if (edge.getFirstVertex().compareTo(vertex) == 0) {
        adjacentEdges.add(edge);
      }
    }

    return adjacentEdges;
  }

  /**
   * Adds an unweighted directed edge to the graph. Throws an exception, as this
   * method should not be used for weighted graphs.
   * 
   * @param first  the first vertex
   * @param second the second vertex
   * @return false, as this method should not be used for weighted graphs
   * @throws IllegalArgumentException always thrown, as this method should not be
   *                                  used for weighted graphs
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second) {
    throw new IllegalArgumentException(
        "Please specify a weight for the edge by using addEdge(Vertex<T> first, Vertex<T> second, W weight).");
  }

  @Override
  /**
   * Returns a string representation of the graph.
   */
  public String toString() {
    return "DirectedWeightedGraph [vertices=" + vertices + ", edges=" + edges + "]";
  }
}
