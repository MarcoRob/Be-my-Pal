
public class LinkedSortedList implements UnsortedListInterface {

	protected int listSize;
	protected LinkedListNode<String> next;
	protected LinkedListNode<String> firstValue;
	protected LinkedListNode<String> targetLocation;
	protected LinkedListNode<String> pre;
	protected boolean found;

	public LinkedSortedList() {
		this.listSize = 0;
		this.firstValue = null;
		this.next = null;
	}

	public void add(String value) {
		if (this.firstValue == null) {
			LinkedListNode<String> nuevo = new LinkedListNode<>();
			nuevo.setHead(value);
			this.firstValue = nuevo;
		} else {
			this.targetLocation = this.firstValue;
			this.pre = null;
			while (this.targetLocation != null) {
				if (this.targetLocation.getHead().compareTo(value) < 0) {
					this.pre = this.targetLocation;
					this.targetLocation = this.targetLocation.getNext();
				} else {
					break;
				}
			}
			LinkedListNode<String> newNode = new LinkedListNode<>();
			if (this.pre == null) {
				newNode.setHead(value);
				newNode.setNext(this.firstValue);
				this.firstValue = newNode;
			} else {
				newNode.setHead(value);
				newNode.setNext(this.targetLocation);
				this.pre.setNext(newNode);
			}
		}
		this.listSize++;
	}

	public void find(String target) {
		this.targetLocation = this.firstValue;
		this.pre = null;
		this.found = false;

		while (this.targetLocation != null) {
			if (this.targetLocation.getHead().compareTo(target) == 0) {
				this.found = true;
				break;
			} else {
				this.pre = this.targetLocation;
				this.targetLocation = this.targetLocation.getNext();
			}
		}

	}

	public int size() {
		return this.listSize;
	}

	public boolean contains(String value) {
		find(value);
		return this.found;
	}

	public boolean remove(String value) {
		if (contains(value)) {
			if (this.firstValue == this.targetLocation) {
				this.firstValue = this.firstValue.getNext();
			} else {
				this.pre.setNext(this.targetLocation.getNext());
			}
			this.listSize--;
		}
		return this.found;
	}

	public String get(String value) {
		if (contains(value)) {
			return this.targetLocation.getHead();
		} else {
			return null;
		}
	}
	
	public void printing() {
		this.targetLocation = this.firstValue;
		while(this.targetLocation != null) {
			System.out.println(this.targetLocation.getHead());
			this.targetLocation = this.targetLocation.getNext();
		}
	}

	public void reset() {
		this.next = this.firstValue;
	}

	public String getNext() {

		LinkedListNode<String> next = new LinkedListNode<>();
		next = this.next;
		this.next = this.next.getNext();
		return next.getHead();
	}

	public String toString() {
		String stTotal = "";
		String st = "";
		LinkedListNode<String> duplicate = this.firstValue;

		for (int i = 0; i < this.listSize; i++) {
			st = duplicate.getHead() + ", ";
			duplicate = duplicate.getNext();
			stTotal = stTotal + st;
		}
		return stTotal;
	}
}
