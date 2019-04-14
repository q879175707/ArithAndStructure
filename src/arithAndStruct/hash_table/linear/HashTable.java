package arithAndStruct.hash_table.linear;

public class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	// for deleted items
	private DataItem nonItem;
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable() {
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j ++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println();
	}
	
	public int hashFunc(int key) {
		return key % arraySize;
	}
	
	public void insert(DataItem item) {
		// assumes table not full
		int key = item.getKey();
		int hashVal = hashFunc(key);
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			++hashVal;	// go to next cell
			hashVal %= arraySize;	// wraparound if necessary
		}
		
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key) {
		int hashVal = hashFunc(key);
		
		while (hashArray[hashVal] != null) { // until empty cell end
			
			if (hashArray[hashVal].getKey() == key) { // found the key?
				DataItem temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = nonItem;			// delete item
				return temp;								// return item
			}
			++hashVal;		// go to next cell
			hashVal %= arraySize;	// wraparound if necessary
		}
		return null; // can't find item
	}
	
	public DataItem find(int key) {
		int hashVal = hashFunc(key);
		
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key)
				return hashArray[hashVal];
			++hashVal;
			hashVal %= arraySize;
		}
		
		return null;
	}
}
