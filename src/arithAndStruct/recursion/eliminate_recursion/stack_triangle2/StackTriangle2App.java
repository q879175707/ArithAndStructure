package arithAndStruct.recursion.eliminate_recursion.stack_triangle2;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class StackTriangle2App {
	static int number;
	static int answer;
	static StackX stack;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		number = Input.getInt();
		
		stackTriangle();
		System.out.println("Triangle = " + answer);
	}

	private static void stackTriangle() {
		stack =  new StackX(10000);
		answer = 0;
		
		while (number > 0) {
			stack.push(number);
			-- number;
		}
		
		while (!stack.isEmpty()) {
			int newN = stack.pop();
			answer += newN;
		}
	}
}
