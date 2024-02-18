package java17;

class Hippo {
	static {
		System.out.print("A");
	}
}

public class InitializingObjectPriority extends Hippo {

	public static void main(String[] args) {
		System.out.println("C"); // ABC
		
	}
	
	static {
		System.out.print("B");
	}

}
