package arithAndStruct.hash_table.hash_chain;

public class Link {
	private int iData;
	public Link next;
	
	public Link(int it) {
		iData = it;
	}
	
	public int getKey() {
		return iData;
	}
	
	public void displayLink() {
		System.out.print(iData + " ");
	}
}
