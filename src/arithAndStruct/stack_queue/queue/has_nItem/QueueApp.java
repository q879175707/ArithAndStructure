package arithAndStruct.stack_queue.queue.has_nItem;

public class QueueApp {
	public static void main(String[] args) {
		arithAndStruct.stack_queue.queue.no_nItem.Queue theQueue = new arithAndStruct.stack_queue.queue.no_nItem.Queue(5);
		
		theQueue.insert(10);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(40);
		
		theQueue.remove();
		theQueue.remove();
		theQueue.remove();
		
		theQueue.insert(50);
		theQueue.insert(60);
		theQueue.insert(70);
		theQueue.insert(80);
		boolean b = theQueue.isEmpty();
		boolean c = theQueue.isFull();
		System.out.println("The Queue is Empty? The Answer is :" + b);
		System.out.println("The Queue is Full? The Answer is :" + c);
		while (!theQueue.isEmpty()) {
			long n = theQueue.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println();
	}
}
