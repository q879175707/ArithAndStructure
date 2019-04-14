package arithAndStruct.stack_queue.stack_brackets;

public class BracketChecker {
	private String input;

	public BracketChecker(String input) {
		this.input = input;
	}

	public void check() {
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // get char
			switch (ch) {
			case '{': // opening symbols
			case '[':
			case '(':
				theStack.push(ch); // push them
				break;
			case '}': // closing symbols
			case ']':
			case ')':
				if (!theStack.isEmpty()) { // if stack not empty,
					char chx = theStack.pop(); // pop and check
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '('))
						System.out.println("Error: " + ch + " at " + j);
				} else {
					System.out.println("Error: " + ch + " at " + j);
				}
				break;
			default:
				break;
			} // end switch
		} // end for
		if (!theStack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
		}
	}
	
}
