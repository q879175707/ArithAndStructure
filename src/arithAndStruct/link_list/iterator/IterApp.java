package arithAndStruct.link_list.iterator;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class IterApp {
	public static void main(String[] args) throws IOException {
		LinkList list = new LinkList();
		ListIterator iter1 = list.getIterator();
		long value;
		
		iter1.insertAfter(20);
		iter1.insertAfter(40);
		iter1.insertAfter(80);
		iter1.insertBefore(60);
		
		while (true ) {
			System.out.print("Enter first letter of show, reset, ");
			System.out.print("next, get, before, after, delete: ");
			System.out.flush();
			
			int choice = Input.getChar();
			switch (choice) {
			case 's':
				if (!list.isEmpty())
					list.displayList();
				else
					System.out.println("List is empty");
				break;
			case 'r':
				iter1.reset();
				break;
			case 'n':
				if (!list.isEmpty() && !iter1.atEnd())
					iter1.nextLink();
				else
					System.out.println("Can't go to next link");
				break;
			case 'g':
				if (!list.isEmpty()) {
					value = iter1.getCurrent().dData;
					System.out.println("Returned " + value);
				} else
					System.out.println("List is empty");
				break;
			case 'b':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = Input.getInt();
				iter1.insertBefore(value);
				break;
			case 'a':
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = Input.getInt();
				iter1.insertAfter(value);
				break;
			case 'd':
				if (!list.isEmpty()) {
					value = iter1.deleteCurrent();
					System.out.println("Deleted " + value);
				} else 
					System.out.println("Can't delete");
				break;

			default:
				System.out.println("Invalid entry");
			}
		}
	}
}
