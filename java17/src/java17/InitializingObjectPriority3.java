package java17;

public class InitializingObjectPriority3 extends InitializingObjectPriority {
	
	public InitializingObjectPriority3() {
		System.out.print("D");
	}

	public static void main(String[] args) {
		new InitializingObjectPriority3();
		System.out.println("E"); // ABCDE
		new InitializingObjectPriority3();
		System.out.println("E"); // CDE çünkü static blocklar bir kere çalışır.
	}
	
	{
		System.out.print("C");
	}

}
