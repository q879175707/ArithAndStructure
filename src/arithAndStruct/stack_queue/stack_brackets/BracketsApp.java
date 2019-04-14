package arithAndStruct.stack_queue.stack_brackets;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class BracketsApp {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.println("Enter string containing delimiters:");
			System.out.flush();
			input = Input.getString();
			if (input.equals(""))
				break;
			
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}
}
