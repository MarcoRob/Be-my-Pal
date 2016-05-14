
public class AdjecencyLinkedList<T> {

	//A generic variable to use as an object 
	private T info;
	//A variable that is going to use like a link
	private AdjecencyLinkedList<T> link;
	
	private int edge;
	
	public AdjecencyLinkedList(int edge, T info) {
		this.setInfo(info);
		this.setEdge(edge);
	}
	
	public AdjecencyLinkedList(T info){
		this.setInfo(info);
	}
	
	public void setEdge(int edge){
		this.edge = edge;
	}
	
	public int getEdge(){
		return this.edge;
	}
	
	public T getInfo() {
		return this.info;
	} 

	public void setInfo(T info) {
		this.info = info;
	} 
	
	public AdjecencyLinkedList<T> getLink() {
		return this.link;
	} 
	
	public void setLink(AdjecencyLinkedList<T> link) {
		this.link = link;		
	} 
	


}
