package arithAndStruct.recursion.eliminate_recursion.stack_triangle1;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class StackTriangleApp {
	static int number;
	static int theAnswer;
	static StackX theStack;
	static int codePart;
	static Params params;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number:");
		number = Input.getInt();
		recTriangle();
		System.out.println("Triangle=" + theAnswer);
	}

	private static void recTriangle() {
		theStack = new StackX(10000);
		codePart = 1;
		while (step() == false)
			;
	}

	private static boolean step() {
		switch (codePart) {
		case 1:
			params = new Params(number, 6);
			theStack.push(params);
			codePart = 2;
			break;
		case 2:
			params = theStack.peek();
			if (params.n == 1) {
				theAnswer = 1;
				codePart = 5;
			} else
				codePart = 3;
			break;
		case 3:
			Params newParams = new Params(params.n - 1, 4);
			theStack.push(newParams);
			codePart = 2;
			break;
		case 4:
			params = theStack.peek();
			theAnswer = theAnswer + params.n;
			codePart = 5;
			break;
		case 5:
			params = theStack.peek();
			codePart = params.returnAddress;
			theStack.pop();
			break;
		case 6:
			return true;

		}
		return false;
	}
}
