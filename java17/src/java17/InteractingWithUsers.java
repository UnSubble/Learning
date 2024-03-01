package java17;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractingWithUsers {

	public static void main(String[] args) throws IOException {
		System.err.println("Error"); // IDE ile çalıyorsak System.out'a göre farklı renkte gösterir.
		var reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		reader.close();
		System.out.println(input);
		
		Console console = System.console(); // IDE üzerindeyken null'dır, cmd'de çalışır.
		if (console != null) {
			String input2 = console.readLine();
			console.writer().println(input2);
		} else {
			System.err.println("console is null");
		}
	}

}
