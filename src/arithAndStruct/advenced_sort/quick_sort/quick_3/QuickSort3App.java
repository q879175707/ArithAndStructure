package arithAndStruct.advenced_sort.quick_sort.quick_3;

import arithAndStruct.advenced_sort.quick_sort.quick_2.ArrayIns;

public class QuickSort3App {
	public static void main(String[] args) {
		int maxSize = 16;
//		int maxSize = 100000000;
		ArrayIns arr = new ArrayIns(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (int) (Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
//		long start = System.currentTimeMillis();
		arr.quickSort();
		arr.display();
//		long end = System.currentTimeMillis();
//		System.out.println("耗时：" + (end - start) + "毫秒");//4500
	}
}
