package DataStructures;

import java.util.HashSet;
import java.util.Set;

import ADTs.GraphADT;

/**
 * A simple (meaning no self-loops), directed, unweighted graph.
 * 
 * @param <T> the type of the data in the vertices
 * @param <V> the type of the vertices
 * @param <E> the type of the edges
 */
public class DirectedGraph<T extends Comparable<T>> implements GraphADT<T, Vertex<T>, DirectedEdge<T>> {
  Set<Vertex<T>> vertices = new HashSet<>();
  Set<DirectedEdge<T>> edges = new HashSet<>();

  /**
   * Creates an empty graph.
   */
  public DirectedGraph() {
  }

  /**
   * Adds a vertex to the graph.
   * 
   * @param vertex the vertex to be added
   * @return true if the vertex is added, false if not
   */
  public boolean addVertex(Vertex<T> vertex) {
    return vertices.add(vertex);
  }

  /**
   * Removes a vertex from the graph. Also removes all edges adjacent to the
   * vertex.
   * 
   * @param vertex the vertex to be removed
   * @return true if the vertex is removed, false if not
   */
  public boolean removeVertex(Vertex<T> vertex) {
    return vertices.remove(vertex);
  }

  /**
   * Connects the two given vertices with a directed edge.
   * 
   * @param first  the first vertex to connect
   * @param second the second vertex to connect
   * @return true if the edge is added, false if not
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second) {
    if(first.compareTo(second) == 0) {
      return false;
    }
    if(vertices.contains(first) && vertices.contains(second)) {
      DirectedEdge<T> edge = new DirectedEdge<>(first, second);
    return edges.add(edge);
    } else {
      return false;
    }
    
  }

  /**
   * Disconnects the two given vertices by removing the edge between them.
   * 
   * @param first  the first vertex to disconnect
   * @param second the second vertex to disconnect
   * @return true if the edge is removed, false if not
   */
  public boolean removeEdge(Vertex<T> first, Vertex<T> second) {
    DirectedEdge<T> edge = new DirectedEdge<>(first, second);
    return edges.remove(edge);
  }

  /**
   * Finds and returns a vertex in the graph.
   * 
   * @param data the vertex to be found
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
   * Returns an iterable of all the vertices in the graph.
   *
   * @return an iterable of all the vertices in the graph
   */
  public Iterable<Vertex<T>> getVertices() {
    return vertices;
  }

  /**
   * Returns an iterable of all the edges in the graph.
   *
   * @return an iterable of all the edges in the graph
   */
  public Iterable<DirectedEdge<T>> getEdges() {
    return edges;
  }

  /**
   * Returns an iterable of all the edges adjacent to the given vertex.
   * 
   * @param vertex the vertex to find adjacent edges for
   * @return an iterable of all the edges adjacent to the given vertex
   */
  public Iterable<DirectedEdge<T>> getAdjacentEdges(Vertex<T> vertex) {
    Set<DirectedEdge<T>> adjacentEdges = new java.util.HashSet<>();

    for (DirectedEdge<T> edge : edges) {
      if (edge.getFirstVertex().compareTo(vertex) == 0) {
        adjacentEdges.add(edge);
      }
    }
    return adjacentEdges;
  }

  @Override
  /**
   * Returns a string representation of the graph.
   */
  public String toString() {
    return "DirectedGraph [vertices=" + vertices + ", edges=" + edges + "]";
  }
}
