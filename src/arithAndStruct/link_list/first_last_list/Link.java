package arithAndStruct.link_list.first_last_list;

public class Link {
	public long dData;
	public Link next;
	
	public Link(long d) {
		dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
