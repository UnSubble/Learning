package java17;

public class Threads {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Hello")).start();
		System.out.println("World");
		// çıktı: HelloWorld veya WorldHello
	}
}
