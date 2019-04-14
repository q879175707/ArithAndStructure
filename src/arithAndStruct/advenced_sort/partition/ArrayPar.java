package arithAndStruct.advenced_sort.partition;

public class ArrayPar {
	private long[] array;
	private int nElems;
	
	public ArrayPar(int max) {
		array = new long [max];
		nElems = 0;
	}
	
	public void insert(long value) {
		array[nElems++] = value;
	}
	
	public int size() {
		return nElems;
	}
	
	public void display() {
		System.out.print("A= ");
		for (int j = 0; j < nElems; j++) 
			System.out.print(array[j] + " ");
		System.out.println();
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while (true) {
			while (leftPtr < right && array[++leftPtr] < pivot); // find bigger item
			while (rightPtr > left && array[--rightPtr] > pivot); // find smaller item
			
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		
		return leftPtr;
	}
	
	public void swap(int dex1, int dex2) {
		long temp;
		temp = array[dex1];
		array[dex1] = array[dex2];
		array[dex2] = temp;
	}
}
