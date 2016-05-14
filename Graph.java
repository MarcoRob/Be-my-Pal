
import Queue.LinkedUnbndQueue;
import Queue.UnboundedQueueInterface;

public class Graph<T> implements WeightedGraphInterface<T>{

	private AdjecencyLinkedList<T>[] graph;
	//private AdjecencyLinkedList<Integer> adjencyNodes;
	private T[] vertices;
	private int sizeGraph,
				numVertices;
	private boolean[] marks;
	
	public Graph(int sizeGraph) {
		this.graph = new AdjecencyLinkedList[sizeGraph];
		this.sizeGraph = sizeGraph;
		this.vertices = (T[]) new Object[sizeGraph];
		this.numVertices = 0;
		this.marks= new boolean[this.sizeGraph];
		clearMarks();
	}
	
	public boolean isEmpty() {
		return (this.numVertices == 0);
	}

	
	public boolean isFull() {
		return (this.numVertices == this.sizeGraph);
	}

	
	public void addVertex(T vertex) {
		if(isFull()){
			throw new RuntimeException();
		} else{
			this.vertices[this.numVertices] = vertex;
		} this.numVertices ++;
	}
	
	public void addVertex(T vertex, int index) {
		if(isFull()){
			throw new RuntimeException();
		} else{
			this.vertices[index] = vertex;
		} this.numVertices ++;
	}

	public boolean hasVertex(T vertex){
		for(int i = 0; i < this.numVertices; i++){
			if(this.vertices[i].equals(vertex)){
				return true;
			}
		} return false;
	}
	
	public void addEdge(T fromVertex, T toVertex, int weight) {
		int start = indexIs(fromVertex);
		int last = indexIs(toVertex);
		AdjecencyLinkedList<Integer> adjencyNode = new AdjecencyLinkedList(last, weight);
		AdjecencyLinkedList<Integer> currentNode = (AdjecencyLinkedList<Integer>) this.graph[start];
		
		if(this.graph[start] == null){
			this.graph[start] = (AdjecencyLinkedList<T>) adjencyNode;
		} else{
			while(currentNode.getLink() != null){
				currentNode = currentNode.getLink();
			} currentNode.setLink(adjencyNode);
		}
	}

	public int indexIs(T vertex){
		int index = 0;
		while(!(vertex.equals(this.vertices[index]))) {
			index ++;
		} return index;
	}
	
	public int weightIs(T fromVertex, T toVertex) {
		int start = indexIs(fromVertex);
		int last = indexIs(toVertex);
		AdjecencyLinkedList<Integer> first= (AdjecencyLinkedList<Integer>) this.graph[start];
		if(first == null){
			return -1;
		} 
		if(first.getEdge() == last){
			return first.getInfo();
		}
		while(first.getLink() != null){
			first = first.getLink();
			if(first.getEdge() == last){
				return first.getInfo();
			}
		} return -1;
		
	}

	
	public UnboundedQueueInterface<T> getToVertices(T vertex) {
		int index = indexIs(vertex);
		LinkedUnbndQueue<T> queue = new LinkedUnbndQueue<T>();
		AdjecencyLinkedList<Integer> first = (AdjecencyLinkedList<Integer>) this.graph[index];
		if(first == null){
			return queue;
		}  queue.enqueue(this.vertices[first.getEdge()]);
		
		while (first.getLink() != null){
			first = first.getLink();
			queue.enqueue(this.vertices[first.getEdge()]);
		} return queue;
	}

	
	public void clearMarks() {
		for(int i = 0; i < this.sizeGraph; i++){
			this.marks[i] = false;
		}
	}

	
	public void markVertex(T vertex) {
		int index = indexIs(vertex);
		this.marks[index] = true;
	}

	
	public boolean isMarked(T vertex) {
		int index = indexIs(vertex);
		return this.marks[index];
	}

	
	public T getUnmarked() {
		for(int i = 0; i < this.numVertices; i++){
			if(!isMarked(this.vertices[i])){
				return this.vertices[i];
			}
		} return null;
	}
	
	public String toString(){
		
		String g = "Graph: \n";
		System.out.println(this.graph[0].getEdge()+"SDFGHJK");
		for(int i = 0; i < this.numVertices; i++){
			g = g + i + " " + this.vertices[i] + " to " + (this.graph[i].getLink().getEdge()) + "\n";
		}
		return g;
	}
	

	
	public String printQueue(T vertex){
		String queue = "Queue: ";
		LinkedUnbndQueue<T> start = (LinkedUnbndQueue<T>) getToVertices(vertex);
		while(!start.isEmpty()){
			queue += "( " + start.dequeue() + " )";
		}
		return queue;
	}
	
public boolean breadthPath(T startVertex, T endVertex){
		
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
			
		}while(!queue.isEmpty()&&!found);
		
		return found;
		
	}
	

}
