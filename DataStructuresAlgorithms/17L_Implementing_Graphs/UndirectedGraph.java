package DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ADTs.*;

/**
 * An undirected, unweighted graph.
 * 
 * @param <T> the type of the data in the vertices
 * @param <V> the type of the vertices
 * @param <E> the type of the edges
 */
public class UndirectedGraph<T extends Comparable<T>> implements GraphADT<T, Vertex<T>, UndirectedEdge<T>> {
  Set<Vertex<T>> vertices;
  Set<UndirectedEdge<T>> edges;

  /**
   * Creates an empty graph.
   */
  public UndirectedGraph() {
    vertices = new java.util.HashSet<Vertex<T>>();
    edges = new java.util.HashSet<UndirectedEdge<T>>();
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
    boolean removed = vertices.remove(vertex);
    
    
    List<UndirectedEdge<T>> edgesToRemove = new ArrayList<>();
    
    
    for (UndirectedEdge<T> edge : edges) {
        if (edge.getFirstVertex().equals(vertex) || edge.getSecondVertex().equals(vertex)) {
            edgesToRemove.add(edge);
        }
    }
    
    
    edges.removeAll(edgesToRemove);
    
    return removed;
  }

  /**
   * Returns the vertex with the given data, or null if no such vertex exists.
   * 
   * @param data the data to search for
   * @return the vertex with the given data, or null if no such vertex exists
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
   * Adds an edge to the graph.
   * 
   * @param first  the first vertex
   * @param second the second vertex
   * @return true if the edge is added, false if not
   */
  public boolean addEdge(Vertex<T> first, Vertex<T> second) {
    if(first.compareTo(second) == 0) {
      return false;
    }
    if(vertices.contains(first) && vertices.contains(second)) {
      UndirectedEdge<T> edge = new UndirectedEdge<>(first, second);
    return edges.add(edge);
    } else {
      return false;
    }
  }

  /**
   * Removes an edge from the graph.
   * 
   * @param edge the edge to be removed
   * @return true if the edge is removed, false if not
   */
  public boolean removeEdge(Vertex<T> first, Vertex<T> second) {
    UndirectedEdge<T> edgeToRemove = null;
    for (UndirectedEdge<T> edge : edges) {
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
   * Returns all vertices in the graph.
   *
   * @return an iterable of all vertices in the graph
   */
  public Iterable<Vertex<T>> getVertices() {
    return vertices;
  }

  /**
   * Returns all edges in the graph.
   * 
   * @return an iterable of all edges in the graph
   */
  public Iterable<UndirectedEdge<T>> getEdges() {
    return edges;
  }

  /**
   * Returns the number of edges incident on a vertex.
   * 
   * @param vertex the vertex
   * @return the number of edges incident on the vertex
   */
  public Iterable<UndirectedEdge<T>> getAdjacentEdges(Vertex<T> vertex) {
    Set<UndirectedEdge<T>> adjacentEdges = new java.util.HashSet<UndirectedEdge<T>>();

    for (UndirectedEdge<T> edge : edges) {
      if (edge.getFirstVertex().compareTo(vertex) == 0 || edge.getSecondVertex().compareTo(vertex) == 0) {
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
    return "UndirectedGraph [vertices=" + vertices + ", edges=" + edges + "]";
  }
}
