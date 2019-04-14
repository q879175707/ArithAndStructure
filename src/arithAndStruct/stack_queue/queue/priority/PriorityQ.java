package arithAndStruct.stack_queue.queue.priority;

public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ (int maxSize) {
		this.maxSize = maxSize;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item) {
		int j;
		if (nItems == 0)
			queArray[nItems++] = item;
		else {
			for (j = nItems - 1; j >= 0; j--) {
				if (item > queArray[j])
					queArray[j + 1] = queArray[j];
				else
					break;
			} // end for
			queArray[j + 1] = item;
			nItems++;
		}// end else (nItems > 0)
	}
	
	public long remove() {
		return queArray[--nItems];
	}
	
	public long peekMin() {
		return queArray[nItems - 1];
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}
}
