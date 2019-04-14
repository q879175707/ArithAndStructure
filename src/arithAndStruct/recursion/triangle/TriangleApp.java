package arithAndStruct.recursion.triangle;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class TriangleApp {
	static int theNumber;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = Input.getInt();
		
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle=" + theAnswer);
	}
	
	public static int triangle(int n) {
		if (n == 1)
			return 1;
		else 
			return (n + triangle(n - 1));
	}
}
