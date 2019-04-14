package arithAndStruct.simple_sort.bubble;

public class BubbleSortApp {
	public static void main(String[] args) {
		int max = 100;
		ArrayBub arr = new ArrayBub(max);
		arr.insert(77);
		arr.insert(22);
		arr.insert(3123);
		arr.insert(54);
		arr.insert(31);
		arr.insert(78);
		arr.insert(123);
		arr.insert(456);
		arr.insert(978);
		arr.insert(44);
		
		arr.display();
		arr.bubbleSort();
		arr.display();
	}
}
