package ADTs;

public interface GraphADT<T extends Comparable<T>, V extends VertexADT<T>, E extends EdgeADT<T, V>> {
  /**
   * Adds a vertex to the graph.
   * 
   * @param vertex the vertex to be added
   * @return true if the vertex is added, false if not
   */
  public boolean addVertex(V vertex);

  /**
   * Removes a vertex from the graph.
   * 
   * @param vertex the vertex to be removed
   * @return true if the vertex is removed, false if not
   */
  public boolean removeVertex(V vertex);

  /**
   * Finds and returns a vertex in the graph.
   *
   * @param data the vertex to be found
   * @return the vertex if found, null if not
   */
  public V getVertex(T data);

  /**
   * Adds an edge to the graph.
   * 
   * @param edge the edge to be added
   * @return true if the edge is added, false if not
   */
  public boolean addEdge(V first, V second);

  /**
   * Removes an edge from the graph.
   * 
   * @param edge the edge to be removed
   * @return true if the edge is removed, false if not
   */
  public boolean removeEdge(V first, V second);

  /**
   * Returns the number of vertices in the graph.
   * 
   * @return the number of vertices in the graph
   */
  public int getVertexCount();

  /**
   * Returns the number of edges in the graph.
   * 
   * @return the number of edges in the graph
   */
  public int getEdgeCount();

  /**
   * Returns an iterable of all the vertices in the graph.
   *
   * @return an iterable of all the vertices in the graph
   */
  public Iterable<V> getVertices();

  /**
   * Returns an iterable of all the edges in the graph.
   *
   * @return an iterable of all the edges in the graph
   */
  public Iterable<E> getEdges();

  /**
   * Returns an iterable of all the edges that are adjacent to a given vertex in
   * the graph.
   *
   * @param vertex the vertex whose adjacent edges are to be returned
   * @return an iterable of all the edges that are adjacent to the given vertex
   */
  public Iterable<E> getAdjacentEdges(V vertex);
}