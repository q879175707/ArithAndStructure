package arithAndStruct.link_list.simple_link;

public class LinkListApp {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		
		list.insertFirst(22, 2.22);
		list.insertFirst(33, 3.33);
		list.insertFirst(44, 4.44);
		list.insertFirst(55, 5.55);
		list.insertFirst(66, 6.66);
		
		list.displayList();
		
		while( !list.isEmpty()) {
			Link aLink = list.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println();
		}
		list.displayList();
	}
}
