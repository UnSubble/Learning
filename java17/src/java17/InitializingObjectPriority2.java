package java17;

public class InitializingObjectPriority2 {

	public static void main(String[] args) {
		System.out.print("C");
		new InitializingObjectPriority(); // CAB
	}

}
