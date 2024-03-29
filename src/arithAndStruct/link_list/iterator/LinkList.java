package arithAndStruct.link_list.iterator;

public class LinkList {
	private Link first;
	
	public Link getFirst() {
		return first;
	}
	
	public void setFirst(Link f) {
		first = f;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public ListIterator getIterator() {
		return new ListIterator(this);
	}
	
	public void displayList() {
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}
