package java17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Generics {
	// private static void add(List<Integer> list) {
	// }
	
	// private static void add(List<String> list) { // DOES NOT COMPILE generic ifadeyi değiştirerek 
													// metot overloaded yapılamaz. Çünü java compile ettiği
	// }                                            // zaman generic classlar için tek bir dosya oluşturur
													// ve bu classta generic ifadeler Object tipinde olur. 
													// Buna type erasure denir.
													// Aynı zamanda override da olamaz. Generic tipin aynı
													// olması lazım.
	
	public void add(List<Integer> list) {}
	public void add(ArrayList<Integer> list) {}
	
	public static void v(ArrayList<Object> list) {
	}
	
	public static void add2(List<?> list) { // ? -> unbounded generic type demek
		// list.add(2); // DOES NOT COMPILE çünkü tip güvenliği var.
		// list.add("ss"); // DOES NOT COMPILE
		list.add(null); // her nesne null olabilir o yüzden Legal.
	}
	
	public static void add3(List<? super String> list) {
		list.add("test");
		list.add("e");
	}
	
	public static <T extends Integer & Comparator<T>> T func(T s) { // aradaki & işareti ikisini de kalıtan
		return null;												// demek için.
	}
	
	public static void main(String[] args) {
		// v(new ArrayList<String>()); // DOES NOT COMPILE
		
		List<String> list = new ArrayList<>();
		// List<Object> list2 = list; // DOES NOT COMPILE
		
		var x = new ArrayList<>(); // ArrayList<Object> x = new ArrayList<>();
		

		List<? extends IOException> io8 = new ArrayList<FileNotFoundException>();
		List<? extends IOException> io6 = new ArrayList<IOException>(); // Legal
		List<? extends IOException> io7 = new ArrayList<>(); // List<? extends IOException> io4 = 
														   // 				 new ArrayList<IOException>();
		// List<? extends IOException> io5 = new ArrayList<Exception>(); // DOES NOT COMPILE
		
		
		List<? super IOException> io = new ArrayList<Exception>(); // Legal
		List<? super IOException> io3 = new ArrayList<IOException>(); // Legal
		List<? super IOException> io4 = new ArrayList<>(); // List<? super IOException> io4 = 
														   // 				 new ArrayList<IOException>();
		// List<? super IOException> io2 = new ArrayList<FileNotFoundException>(); // DOES NOT COMPILE
		
		// List<String> list = new ArrayList<? extends String>(); // sağ tarafta bounded generic olamaz.
		
	}
}

class Mammal2 {
	public List<CharSequence> play() {return null;}
}

class Monkey extends Mammal2 {
	@Override
	public ArrayList<CharSequence> play() {return null;}
}

//class Goat extends Mammal { // DOES NOT COMPILE 
//	@Override
//	public List<String> play() {return null;}
//}



class Generic<T> {
	//T getAnimal() { // DOES NOT COMPILE çünkü generic tipten constructor çağıramıyoruz.
	//	return new T();
	//}
	
	void sample() {
		// T[] arr = new T[100]; // DOES NOT COMPILE generic tipten array oluşturamayız. 
								 // Yalnızca casting yapabiliriz.
		T[] arr; // referans olarak verebiliyoruz.
		T obj;
	}
	
	void sample(T t) {
		System.out.println(t instanceof String);
	}
	
	void sample(List<T> list) {
		// System.out.println(list instanceof ArrayList<Integer>); // DOES NOT COMPILE
		// System.out.println(list instanceof List<Integer>); // DOES NOT COMPILE
		System.out.println(list instanceof List<T>);
	}	
}


class Box {
	public static <T> void ship(T t) {
		System.out.println(t);
	}
	
	void call() {
		Box.<Integer>ship(3); // bu şekilde tipini verebiliyoruz.
	}
}



class TrickyCrate<T> {
	public <T> T tricky(T t) {
		return t;
	}
	
	public T tricky2(T t) {
		return t;
	}
	
	public <U> U tricky3(U u) {
		return u;
	}
	
	public void call() {
		TrickyCrate<Integer> tc = new TrickyCrate<>();
		tc.tricky("Test1");
		// tc.tricky2("test2"); // DOES NOT COMPILE
		tc.tricky2(3);
		tc.tricky3("Test3");
	}
}