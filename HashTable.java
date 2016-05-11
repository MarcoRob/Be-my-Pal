import java.util.Random;

public class HashTable {
	private int tableSize;
	private LinkedSortedList [] hashT;

	public HashTable(int tableSize) {
		this.hashT = new LinkedSortedList[tableSize];
		this.tableSize = tableSize;
	}
	
	public HashTable(LinkedSortedList [] hashT) {
		this.tableSize = hashT.length;
		this.hashT = hashT;
	}

	public void insert(String key) {
		int index = cKey(key);
		if (this.hashT[index] == null) {
			LinkedSortedList newList = new LinkedSortedList();
			newList.add(key);
			this.hashT[index] = newList;
		}
		else {
			this.hashT[index].add(key);
		}
	}

	public boolean search(String key) {
		int pos = cKey(key);
		if (this.hashT[pos] != null && this.hashT[pos].contains(key)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean delete(String key) {
		int pos = cKey(key);
		if (this.hashT[pos] != null && this.hashT[pos].remove(key)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int cKey(String value){
		int rKey = 0;
		for (int i = 0; i < value.length(); i++) {
			System.out.println(value.length());
			System.out.println((int) value.charAt(i));
			rKey = rKey + (int)value.charAt(i);
			System.out.println(rKey);
		}
		System.out.println("Pos " + rKey%this.tableSize);
		return rKey%this.tableSize;
	}
	
	public int[][] randomMatrix(int key) {
		String columns = Integer.toBinaryString(key);
		String rows = Integer.toBinaryString(this.tableSize-1);
		int [][] hashM = new int[rows.length()][columns.length()];
		for (int i = 0; i < hashM.length; i++) {
			for (int j = 0; j < hashM[i].length; j++) {
				hashM[i][j] = new Random().nextInt(2);
			}
		}
		return hashM;
	}
	
	public int multiplication(int[][] hashM, int Key) {
		String bKey = Integer.toBinaryString(Key);
		int tempMultiplyNo = 0;
		String rKey = "";
		for (int i = 0; i < hashM.length; i++) {
			for (int j = 0; j < hashM[i].length; j++) {
				tempMultiplyNo = tempMultiplyNo + hashM[i][j] * bKey.charAt(j);
			}
			rKey = rKey + (tempMultiplyNo%2);
		}
		return Integer.parseInt(rKey,2);
	}
	
	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}
	
	public String toString() {
		String string = "";
		String stringT = "";
		
		for (int i = 0; i < this.tableSize; i++) {
			string = this.hashT[i] + "\n";
			stringT = stringT + string;
		}
		return stringT;
	}
	
	public static void main(String[] args){
		HashTable ht = new HashTable(5);
		ht.insert("A");
		ht.insert("B");
		ht.insert("C");
		ht.insert("D");
		ht.insert("E");
		System.out.println(ht.search("C"));
		System.out.println(ht);
	}
}
