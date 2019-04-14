package arithAndStruct.advenced_sort.quick_sort.quick_1;

public class QuickSort1App {
	public static void main(String[] args) {
		int maxSize = 100000000;
		ArrayIns arr = new ArrayIns(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int)(Math.random() * 99);
			arr.insert(n);
		}
		
//		arr.display();
		long start = System.currentTimeMillis();
		arr.quickSort();
		long end = System.currentTimeMillis();
		System.out.println("共用时间" + (end - start));//4720
//		arr.display();
	}
}
