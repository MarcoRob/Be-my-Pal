
public interface ListInterface {
	int size();
	void add(String value);
	boolean remove(String value);
	boolean contains(String value);
	String get(String value);
	String toString();
	void reset();
	String getNext();
}
