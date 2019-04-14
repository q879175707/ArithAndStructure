package arithAndStruct.stack_queue.analytic_arithmetic_expression;

public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int s) {
		this.maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char j) {
		stackArray[++top] = j;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public char PeekN(int n) {
		return stackArray[n];
	}
	
	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (bottom-->top):");
		
		for (int j = 0; j < size(); j++) {
			System.out.print(PeekN(j));
			System.out.print(' ');
		}
		System.out.println();
		
	}
}
