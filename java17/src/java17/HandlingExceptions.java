package java17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyClass implements AutoCloseable {
	private final int n;
	
	public MyClass(int n) {
		this.n = n;
	}

	@Override
	public void close() throws RuntimeException {
		throw new RuntimeException(String.valueOf(n));
	}
	
}

public class HandlingExceptions {
	@SuppressWarnings("finally")
	public static void main(String[] args) {
		// Throwable ve error'ları catch ile yakalayabiliriz ancak bu önerilmez.
		
		try {
			throw new ArrayIndexOutOfBoundsException();
			// throw new RuntimeException(); // DOES NOT COMPILE çünkü ulaşılamaz.
		} catch (Exception e) {
		}
		
		System.out.println(method()); // 1 3 return: 3
		
		System.out.println(methodO()); // O1 O2 O3 return: 3
		
		try (MyClass clzz = new MyClass(2);
				MyClass clzz2 = new MyClass(3)) {
			throw new RuntimeException("1"); // ilk fırlatılan exception primary diğerleri suppressed exp
		} catch (RuntimeException e) {
			System.out.println(e.getMessage()); // 1
			for (Throwable t : e.getSuppressed()) {
				System.out.println(t.getMessage()); // 3 2
			}
		}
		
		try {
			throw new RuntimeException();
		} finally {
			throw new IllegalStateException(); // burada IllegalStateException, RuntimeException'ı ezer.
		}										// RuntimeException istisnası hiçbir şekilde gösterilmez.
	}
	
	@SuppressWarnings("finally")
	public static int method() {
		try {
			System.out.println("1");
			return 1;
		} catch (RuntimeException e) {
			System.out.println("2");
			return 2;
		} finally {
			System.out.println("3");
			return 3;
		}
	}
	
	@SuppressWarnings("finally")
	public static int methodO() {
		try {
			System.out.println("O1");
			throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println("O2");
			return 2;
		} finally {
			System.out.println("O3");
			return 3;
		}
	}
	
	public void exit() {
		try {
			System.exit(0);
		} finally {
			System.out.println("calismayacak"); // System.exit() finally bloğunu ezer.
		}
	}
	
	public void method1() {
	}
	
	public void method2() {
		// try {
		// 	method1();
		// } catch(FileNotFoundException e) { // DOES NOT COMPILE çünkü try bloğu bu checked exception'ı 
		// }								// fırlatması  lazım. Ayrıca Exception sınıfı checked olmasına
											// rağmen try bloğu fırlatmasa da kullanılabilir.
		
		try {
			method1();
		} catch(RuntimeException e) {
		}
	}
	
	public void method3() throws Exception {
	}
	
	public void method4() {
		// method3(); // DOES NOT COMPILE çünkü checked exception'ı handle etmesi lazım.
	}
}

class Animal66 {
	// static {
	// 	throw new RuntimeException(); // DOES NOT COMPILE
	// }
	
	void eat() {
	}
	
	void run() {
	}
}

class Dog66 extends Animal66 {
	void eat() throws RuntimeException {
	}
	
	// void run() throws IOException {} // DOES NOT COMPILE çünkü override'ta checked exception seviyesini
														// yükseltemeyiz. 
											// Exception > IOException > FileNotFoundException > nothing...
}


class FileManager {
	
	void connect() {
		try (var in = new FileInputStream("data.txt"); // arada ; zorunlu, sonda ; ise opsiyoneldir.
				var out = new FileOutputStream("data.txt")) { // ilk out sonra in kapatılır.
		} catch (IOException e) {
		}
	}
	
	void make() {
		try (var in = new FileInputStream("data.txt");
				var out = new FileOutputStream("data.txt")) { 
			System.out.println("try block");
			throw new IOException();
		} catch (IOException e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
		}		
		// try block
		// closing out
		// closing in
		// catch block
		// finally block
	}
	
	void main() throws FileNotFoundException {
		final FileReader reader = new FileReader("data.txt");
		FileReader effectivelyReader = new FileReader("data.txt");
		try (reader; FileWriter writer = new FileWriter("data.txt"); effectivelyReader;) {
				// Değişkenler effectively final veya final ise de try-with-resource yapısı kullanılabilir.
				// effectivelyReader -> writer -> reader şeklinde kapanır.
		} catch (IOException e) {
		}
	}
}
