package arithAndStruct.tree._234Tree;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class Tree234App {
	public static void main(String[] args) throws Exception {
		long value;
		Tree234 tree = new Tree234();
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(30);
		tree.insert(70);
		
		while (true) {
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, or find: ");
			char choice = Input.getChar();
			switch (choice) {
			case 's':
				tree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = Input.getInt();
				tree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = Input.getInt();
				int found = tree.find(value);
				if (found != -1)
					System.
					out.println("Found " + value);
				else
					System.out.println("Could not find " + value);
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}
}
