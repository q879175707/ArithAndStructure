package arithAndStruct.stack_queue.stack_inverser;

public class Reverser {
	private String input;
	private String output;
	
	public Reverser(String in) {
		input = in;
	}
	
	public String doRev() {
		int size = input.length();
		StackX theStack = new StackX(size);
		
		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}
		
		output = "";
		while (!theStack.isEmpty()) {
			char ch = theStack.pop();
			output = output + ch;
		}
		
		return output;
	}
}
