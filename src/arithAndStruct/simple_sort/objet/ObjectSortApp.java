package arithAndStruct.simple_sort.objet;

public class ObjectSortApp {
	public static void main(String[] args) {
		int max = 100;
		ArrayInOb arr = new ArrayInOb(max);
		arr.insert("Evans", "Patty", 24);
		arr.insert("Smith", "Doc", 24);
		arr.insert("Smith", "Lorraine", 24);
		arr.insert("Smith", "Paul", 24);
		arr.insert("Yee", "Tom", 24);
		arr.insert("Hashimoto", "Sato", 24);
		arr.insert("Stimson", "Henry", 24);
		arr.insert("Velasquez", "Jose", 24);
		arr.insert("Vang", "Minh", 24);
		arr.insert("Creswell", "Lucinda", 24);
		
		System.out.println("Before sorting");
		arr.display();
		System.out.println("After sorting:");
		arr.insertionSort();
		arr.display();
	}
}
