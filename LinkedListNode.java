
public class LinkedListNode<Anytype> {
	private Anytype head;
	private LinkedListNode<Anytype> next;
	private int listCount;
	
	public LinkedListNode(){
		this.head = null;
		this.next = null;
		this.listCount = 0; 
	}
	
	public LinkedListNode(Anytype head){

		this.head = head;
		this.next = null;
		this.listCount = 0; 
	}
	
	public void add(Anytype data){
		LinkedListNode<Anytype> newLink = new LinkedListNode<>();
		LinkedListNode<Anytype> temporalLink = this;
	
		newLink.setHead(data);
		if (this.head == null) {
			this.head = data;
		}
		else{
			while (temporalLink.getNext() != null) {
				temporalLink = temporalLink.getNext(); 
			}
			temporalLink.setNext(newLink);
		}
		this.listCount++;
	}

	public Anytype getHead() {
		return head;
	}

	public void setHead(Anytype head) {
		this.head = head;
	}

	public LinkedListNode<Anytype> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<Anytype> next) {
		this.next = next;
	}
	
	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
}
