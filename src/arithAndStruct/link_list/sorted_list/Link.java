package arithAndStruct.link_list.sorted_list;

public class Link {
	public long dData;
	public Link next;
	
	public Link(long dd) {
		dData = dd;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}
