package arithAndStruct.link_list.stack;

public class LinkStack {
	private LinkList list;
	
	public LinkStack() {
		list = new LinkList();
	}
	
	public void push(long j) {
		list.insertFirst(j);
	}
	
	public long pop() {
		return list.deleteFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void displayStack() {
		System.out.print("Stack (top-->bottom):");
		list.displayList();
	}
}
