//----------------------------------------------------------------------------
// WeightedGraph.java            by Dale/Joyce/Weems                 Chapter 9
//
// Implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------


import Queue.*;

public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
	public static final int NULL_EDGE = 0;
	private static final int DEFCAP = 500;  // default capacity
	private int numVertices;
	private int maxVertices;
	private T[] vertices;
	private int[][] edges;
	private boolean[] marks;  // marks[i] is mark for vertices[i]

	public WeightedGraph()
	// Instantiates a graph with capacity DEFCAP vertices.
	{
		numVertices = 0;
		maxVertices = DEFCAP;
		vertices = (T[]) new Object[DEFCAP];
		marks = new boolean[DEFCAP];
		edges = new int[DEFCAP][DEFCAP];
	}

	public WeightedGraph(int maxV)
	// Instantiates a graph with capacity maxV.
	{
		numVertices = 0;
		maxVertices = maxV;
		vertices = (T[]) new Object[maxV];
		marks = new boolean[maxV];
		edges = new int[maxV][maxV];
	}

	public boolean isEmpty()
	// Returns true if this graph is empty; otherwise, returns false.
	{
		if(numVertices == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isFull()
	// Returns true if this graph is full; otherwise, returns false.
	{
		if(numVertices >= maxVertices || numVertices >= DEFCAP){
			return true;
		}
		else{
			return false;
		}
	}

	public void addVertex(T vertex)
	// Preconditions:   This graph is not full.
	//                  Vertex is not already in this graph.
	//                  Vertex is not null.
	//
	// Adds vertex to this graph.
	{
		vertices[numVertices] = vertex;
		for (int index = 0; index < numVertices; index++)
		{
			edges[numVertices][index] = NULL_EDGE;
			edges[index][numVertices] = NULL_EDGE;
		}
		numVertices++;
	}
	
	public void addVertex(T vertex, int index) {
		if(isFull()){
			throw new RuntimeException();
		} else{
			this.vertices[index] = vertex;
		} this.numVertices ++;
	}
	
	public void removeVertex(int index) {
		for(int i = index; i < this.numVertices; i++) {
			this.vertices[index] = this.vertices[index + 1];
		}
		this.vertices[this.numVertices] = null;
		this.numVertices--;
	}
	
	public void removeVertex(T vertex) {
		boolean sigueCambiando = false;
		for(int i = 0; i < this.numVertices; i++) {
			if(this.vertices[i].equals(vertex)) {
				sigueCambiando = true;
			}
			if(sigueCambiando) {
				this.vertices[i] = this.vertices[i + 1];
			}
		}
		this.vertices[this.numVertices] = null;
		this.numVertices--;
	}

	public boolean hasVertex(T vertex)
	// Returns true if this graph contains vertex; otherwise, returns false.
	{
		int index = 0;
		while(vertices[index] != vertex){
			index++;
		}
		if(vertices[index] == vertex){
			return true;
		}
		else{
			return false;
		}
	}

	public int indexIs(T vertex)
	// Returns the index of vertex in vertices.
	{
		int index = 0;
		while (!vertex.equals(vertices[index]))
			index++;
		return index;
	}

	public void addEdge(T fromVertex, T toVertex, int weight)
	// Adds an edge with the specified weight from fromVertex to toVertex.
	{
		int row;
		int column;

		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		edges[row][column] = weight;
	}
	
	public void removeEdge(T fromVertex, T toVertex)
	{
		int row;
		int column;

		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		edges[row][column] = 0;
	}

	public int weightIs(T fromVertex, T toVertex)
	// If edge from fromVertex to toVertex exists, returns the weight of edge;
	// otherwise, returns a special “null-edge” value.
	{
		int row;
		int column;

		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		return edges[row][column];
	}

	public UnboundedQueueInterface<T> getToVertices(T vertex)
	// Returns a queue of the vertices that are adjacent from vertex.
	{
		UnboundedQueueInterface<T> adjVertices = new LinkedUnbndQueue<T>();
		int fromIndex;
		int toIndex;
		fromIndex = indexIs(vertex);
		for (toIndex = 0; toIndex < numVertices; toIndex++)
			if (edges[fromIndex][toIndex] != NULL_EDGE)
				adjVertices.enqueue(vertices[toIndex]);
		return adjVertices;
	}

	public void clearMarks()
	// Sets marks for all vertices to false.
	{
		for(int i = 0; i < maxVertices; i++){
			marks[i] = false;
		}
	}

	public void markVertex(T vertex)
	// Sets mark for vertex to true.
	{
		for(int i = 0; i < numVertices; i++){
			if(vertices[i] == vertex){
				marks[i] = true;
				break;
			}
		}
	}

	public boolean isMarked(T vertex)
	// Returns true if vertex is marked; otherwise, returns false.
	{
		int i = 0;
		for(i = 0; i < numVertices; i++){
			if(vertices[i] == vertex){
				break;
			}
		}
		if(marks[i] == true){
			return true;
		}
		else{
			return false;
		}
	}

	public T getUnmarked()
	// Returns an unmarked vertex if any exist; otherwise, returns null.
	{
		boolean found = false;
		int index = 0;
		while ((index < numVertices) && !found)
		{
			if (!marks[index])
				found = true;
			else
				index++;
		}
		if (found)
			return vertices[index];
		else
			return null;
	}
	
	public boolean breadthPath(T startVertex, T endVertex) {
		UnboundedQueueInterface<T> queue = new LinkedUnbndQueue<>();
		UnboundedQueueInterface<T> vertexQueue = new LinkedUnbndQueue<>();
		boolean found = false;
		T vertex;
		T element;

		clearMarks();
		queue.enqueue(startVertex);

		do{
			vertex = (T) queue.dequeue();

			if(vertex==endVertex){
				found=true;
			}else{
				if(!isMarked(vertex)){
					markVertex(vertex);
					vertexQueue = getToVertices(vertex);

					while(!vertexQueue.isEmpty()){
						element=(T) vertexQueue.dequeue();
						if(!isMarked(element)){
							queue.enqueue(element);
						}
					}
				}
			}
		}
		while(!queue.isEmpty()&&!found);
		return found;
	}
}