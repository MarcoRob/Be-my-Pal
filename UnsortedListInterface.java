
public interface UnsortedListInterface extends ListInterface {
	void add(String element);
	void find(String target);
	int size();
	boolean contains(String element);
	boolean remove(String element);
	String get(String element);
	String toString();
	void reset();
	String getNext();
}
