package arithAndStruct.advenced_sort.partition;

public class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayPar arr = new ArrayPar(maxSize);
		for (int j = 0; j < maxSize; j++) {
			long n = (long)(Math.random() * 199);
			arr.insert(n);
		}
		
		arr.display();
		
		long pivot = 99;
		
		System.out.print("Pivot is " + pivot);
		
		int size = arr.size();
		int partDex = arr.partitionIt(0, size - 1, pivot);
		System.out.println(", Partition is at index " + partDex);
		arr.display();
	}
}
