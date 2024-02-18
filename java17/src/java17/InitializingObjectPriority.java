package java17;

public class InitializingObjectPriority extends Hippo {

	public static void main(String[] args) {
		System.out.println("C"); // ABC
		
	}
	
	static {
		System.out.print("B");
	}

}

class Hippo {
	static {
		System.out.print("A");
	}
}