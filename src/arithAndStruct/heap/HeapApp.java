package arithAndStruct.heap;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class HeapApp {
	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap theHeap = new Heap(31);
		boolean success;
		
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		
		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, remove, change: ");
			int choice = Input.getChar();
			switch (choice) {
			case 's':
				theHeap.displayHeap();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = Input.getInt();
				success = theHeap.insert(value);
				if (!success)
					System.out.println("Can't insert; heap full");
				break;
			case 'r':
				if (!theHeap.isEmpty())
					theHeap.remove();
				else
					System.out.println("Can't remove; heap empty");
				break;
			case 'c':
				System.out.print("Enter current index of item: ");
				value = Input.getInt();
				System.out.print("Enter new key: ");
				value2 = Input.getInt();
				success = theHeap.change(value, value2);
				if (!success)
					System.out.println("Invalid index");
				break;
			default:
				System.out.println("Invalid entry \n");
			}
		}
	}
}
