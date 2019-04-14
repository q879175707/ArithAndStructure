package arithAndStruct.link_list.list_insertion_sort;

public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[]	linkArr = new Link[size];
		
		for (int j = 0; j < size; j++) {
			int n = (int)(Math.random() * 99);
			Link newLink = new Link(n);
			linkArr[j] = newLink;
		}
		
		System.out.print("Unsorted array:");
		for(int j = 0; j < size ; j++)
			System.out.print(linkArr[j].dData + " ");
		System.out.println();
		
		SortedList theSortedList = new SortedList(linkArr);
		
		for (int j = 0; j < size; j++)
			linkArr[j] = theSortedList.remove();
		System.out.print("Sorted 	 array:");
		for (int j = 0; j < size ; j++)
			System.out.print(linkArr[j] .dData + " ");
		System.out.println();
		
	}
}
