package arithAndStruct.recursion.binary_search;

public class BinarySearchApp {
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr = new OrdArray(maxSize);
		
		arr.insert(12);
		arr.insert(312);
		arr.insert(321);
		arr.insert(124);
		arr.insert(85);
		arr.insert(111);
		arr.insert(564);
		arr.insert(78);
		arr.insert(134);
		arr.insert(5553);
		arr.insert(3132);
		arr.insert(4467);
		arr.insert(13233);
		arr.display();
		
		int searchKey = 13233;
		if (arr.find(searchKey) != arr.size())
			System.out.println("FOUND " + searchKey);
		else
			System.out.println("Can't find " + searchKey);
	}
}
