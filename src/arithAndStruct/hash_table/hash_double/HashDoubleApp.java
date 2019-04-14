package arithAndStruct.hash_table.hash_double;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class HashDoubleApp {
	public static void main(String[] args) throws IOException {
		int aKey;
		DataItem aDataItem;
		int size, n;
		
		System.out.print("Enter size of hash table: ");
		size = Input.getInt();
		System.out.print("Enter initial number of items: ");
		n = Input.getInt();
		
		HashTable theHashTable = new HashTable(size);
		
		for (int j = 0; j < n; j++) {
			aKey = (int ) (Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aKey, aDataItem);
		}
		
		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = Input.getChar();
			switch (choice) {
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter key value to insert:");
				aKey = Input.getInt();
				aDataItem = new DataItem(aKey);
				theHashTable.insert(aKey, aDataItem);;
				break;
			case 'd':
				System.out.print("Enter key value to delete:");
				aKey = Input.getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter key value to find:");
				aKey = Input.getInt();
				aDataItem = theHashTable.find(aKey);
				if (aDataItem != null) 
					System.out.print("Found " + aKey); 
				else
					System.out.println("Could not find " + aKey); 
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}
}
