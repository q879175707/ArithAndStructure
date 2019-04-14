package arithAndStruct.advenced_sort.quick_sort.quick_3;

public class ArrayIns {
	private long[] theArray;
	private int nElems;

	public ArrayIns(int maxSize) {
		theArray = new long[maxSize];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems++] = value;
	}

	public void display() {
		System.out.print("A = ");
		for (int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	private void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if (size < 10)
			insertionSort(left, right);
		else {
			long median = medianOf3(left, right);

			int partition = partitionIt(left, right, median);

			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	private long medianOf3(int left, int right) {
		int center = (right + left) / 2;
		if (theArray[left] > theArray[center])
			swap(left, center);
		if (theArray[left] > theArray[right])
			swap(left, right);

		if (theArray[center] > theArray[right])
			swap(center, right);

		swap(center, right - 1);
		return theArray[right - 1];
	}

	private void swap(int dex1, int dex2) {
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}

	private int partitionIt(int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;

		while (true) {
			while (theArray[++leftPtr] < pivot)
				;
			while (theArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);
		return leftPtr;
	}

	private void insertionSort(int left, int right) {
		int in, out;

		for (out = left + 1; out < right; out++) {
			long temp = theArray[out];
			in = out;

			while (in > left && theArray[in - 1] >= temp) {
				theArray[in] = theArray[in - 1];
				--in;
			}
			theArray[in] = temp;
		}
	}
}
