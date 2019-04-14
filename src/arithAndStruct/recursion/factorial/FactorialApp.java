package arithAndStruct.recursion.factorial;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class FactorialApp {
static int theNumber;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number: ");
		theNumber = Input.getInt();
		
		int theAnswer = factorial(theNumber);
		System.out.println("Factorial=" + theAnswer);
	}
	
	public static int factorial(int n) {
		// 0的阶乘被定义为1
		if (n == 0)
			return 1;
		else 
			return (n * factorial(n - 1));
	}
}
