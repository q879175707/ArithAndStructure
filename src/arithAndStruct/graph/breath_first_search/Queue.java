package arithAndStruct.graph.breath_first_search;

public class Queue {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;
	
	public Queue() {
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	/**
	 * put item at rear of queue
	 * @param i
	 */
	public void insert(int i) {
		if (rear == SIZE - 1)
			rear = -1;
		queArray[++rear] = i;
	}
	
	/**
	 * take item from front of queue
	 * @return
	 */
	public int remove() {
		int temp = queArray[front++];
		if (front == SIZE)
			front = 0;
		return temp;
	}
	
	public boolean isEmpty() {
		return (rear + 1 == front || (front + SIZE - 1) == rear);
	}
}
