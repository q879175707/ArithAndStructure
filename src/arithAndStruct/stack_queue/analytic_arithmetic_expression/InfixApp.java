package arithAndStruct.stack_queue.analytic_arithmetic_expression;

import java.io.IOException;

import arithAndStruct.utils.Input;

public class InfixApp {
	public static void main(String[] args) throws IOException {
		String input,output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = Input.getString();
			if (input.equals(""))
				break;
			
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans();
			
			System.out.println("Postfix is " + output + '\n');
		}
	}
}
