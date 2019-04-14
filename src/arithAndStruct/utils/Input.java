package arithAndStruct.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}

	public static char getChar() throws IOException {
		return getString().charAt(0);
	}

	public static int getInt() throws IOException {
		return Integer.parseInt(getString());
	}

	public static long getLong() throws IOException {
		return Long.parseLong(getString());
	}
	public static double getDouble() throws IOException {
		return Double.parseDouble(getString());
	}
}
