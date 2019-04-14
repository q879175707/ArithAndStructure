package arithAndStruct.advenced_sort.quick_sort.quick_2;

public class QuickSort2App {
	public static void main(String[] args) {
//		int maxSize = 16;
		int maxSize = 100000000;
		ArrayIns arr = new ArrayIns(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int) (Math.random() * 99);
			arr.insert(n);
		}
		long start = System.currentTimeMillis();
		arr.quickSort();
		
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒"); // 4181
	}
}
