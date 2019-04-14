package arithAndStruct.advenced_sort.shell;

public class ArraySh {
	private long[] array;
	private int nElems;

	public ArraySh(int max) {
		array = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	public void insert(long value) {
		array[nElems] = value;
		nElems++;
	}
	
	public void display() {
		System.out.print("A=");
		for (int j = 0; j < nElems; j++)
			System.out.print(array[j] + " ");
		System.out.println();
	}
	
	public void shellSort() {
		int inner, outer;
		long temp;
		
		int h = 1;
		while (h <= nElems/3)
			h = h * 3 + 1;
		
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = array[outer]; 
				inner = outer;
				while (inner > h - 1 && array[inner - h] >= temp) {
					array[inner] = array[inner - h];
					inner -= h;
				}// end while 
				array[inner] = temp;
			} // end for
			
			h = (h - 1) / 3;
		} // end while (h > 0)
	}
}
