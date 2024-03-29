package arithAndStruct.link_list.first_last_list;

public class FistLastList {
	private Link first;
	private Link last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			last = newLink;
		newLink.next = first;
		first = newLink;
	}
	
	public void insertLast(long dd) {
		Link newLink = new Link(dd);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}
	
	public long deletFirst() {
		long temp = first.dData;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List (first-->last):");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
}
