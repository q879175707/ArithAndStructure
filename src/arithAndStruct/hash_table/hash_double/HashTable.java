package arithAndStruct.hash_table.hash_double;

public class HashTable {
	
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable() {
		System.out.print("Table: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println();
	}
	
	public int hashFunc1(int key) {
		return key % arraySize;
	}
	
	public int hashFunc2(int key) {
		return 5 - key % 5;
	}
	
	public void insert(int key, DataItem item) {
		// assumes table not full
		int hashVal = hashFunc1(key); // hash the key
		int stepSize = hashFunc2(key); // get step size
		
		// until empty cell or -1
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			hashVal += stepSize;	// add the step
			hashVal %= arraySize;	// for wraparound
		}
		
		hashArray[hashVal] = item; // insert item
	}
	
	public DataItem delete(int key) {
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		
		// until empty cell
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key) { // is correct hashVal?
				DataItem temp = hashArray[hashVal];		// save item
				hashArray[hashVal] = nonItem;				// delete item
				 return temp;									// return item
			}
			
			hashVal += stepSize;	// add the step
			hashVal %= arraySize;	// for wraparound
		}
		
		return null;  // can't find item
	}
	
	
	public DataItem find(int key) {
		// assumes table not full
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		
		while (hashArray[hashVal] != null) {	// until empty cell
			if (hashArray[hashVal].getKey() == key)	// is correct hashVal?
				return hashArray[hashVal];				// yes, return item
			hashVal += stepSize;						// add the step
			hashVal %= arraySize;						// for wraparound
		}
		
		return null; // can't find item
	}
}
