package arithAndStruct.recursion.merge;

public class DArray {
	private long[] array;
	private int nElems;

	public DArray(int max) {
		array = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		array[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int j = 0; j < nElems; j++) 
			System.out.print(array[j] + " ");
		System.out.println();
	}
	
	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound)
			return;
		else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);
			recMergeSort(workSpace, mid + 1, upperBound);
			
			merge(workSpace, lowerBound, mid + 1, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowerPtr, int highPtr, int upperBound) {
		int j = 0; 
		int lowerBound = lowerPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;
		
		while (lowerPtr <= mid && highPtr <= upperBound)
			if (array[lowerPtr] < array[highPtr])
				workSpace[j++] = array[lowerPtr++];
			else
				workSpace[j++] = array[highPtr++];
		
		while (lowerPtr <= mid)
			workSpace[j++] = array[lowerPtr++];
		
		while (highPtr <= upperBound)
			workSpace[j++] = array[highPtr++];
		
		for (j = 0; j< n; j++)
			array[lowerBound + j] = workSpace[j];
	}
}
