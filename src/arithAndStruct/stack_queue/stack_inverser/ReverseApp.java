package arithAndStruct.stack_queue.stack_inverser;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class ReverseApp {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter a String:");
			System.out.flush();
			
			input = Input.getString();
			if (input.equals(""))
				break;
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed:" + output);
		}
	}
}
