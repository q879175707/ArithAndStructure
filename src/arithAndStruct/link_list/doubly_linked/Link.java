package arithAndStruct.link_list.doubly_linked;

public class Link {
	public long dData;
	public Link next;
	public Link previous;
	
	public Link(long d) {
		dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
