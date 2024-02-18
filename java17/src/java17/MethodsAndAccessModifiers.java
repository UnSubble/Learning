package java17;

import pckg2.AccessModifierSample;

public class MethodsAndAccessModifiers {
	private static String str = "Clem";
	
	private int total = 5;
	// private static int average = total / 5; // DOES NOT COMPILE çünkü static bir değişken static olmayan
																// bir değişkene erişemez.
	
	// private static final int TEST;	// DOES NOT COMPILE çünkü static final değişkenlere tanımlandığı
	public MethodsAndAccessModifiers() { // yerde ya da static initializer block'ta değer atayabiliriz.
		// TEST = 0xFFF;
	}
	
	static {
		int n = 7; // LEGAL
		// static int m = 7; // DOES NOT COMPILE çünkü bu block da local'dir.
	}
	
	// final int d; // final olursa tanımlandığı yerde, constructor'da veya initializer block'ta initialize 
				    // edilmek zorundadır. Default value verilmez.
	
	// default void skip1() { } // DOES NOT COMPILE
	
	// public void final skip2() { } // DOES NOT COMPILE
	
	// public void 3skip() { } // DOES NOT COMPILE
	
	public void Jog_$() { }
	
	// public void _() {} // DOES NOT COMPILE
	
	public void twoExceptions() throws IllegalArgumentException, InterruptedException { }
	
	public void fly1() { } // LEGAL
	
	// public int fly2() { } // DOES NOT COMPILE
	
	public void zooAnimalCheckup(boolean isWeekend) {
		final int rest;
		if (isWeekend)
			rest = 5;
		else
			rest = 10;
		System.out.println(rest); // else statement olmasaydı compile olmazdı.
	}
	
	// bir değişkeni final yapınca da bir sıkıntı çıkarmıyorsa buna effectively final denir.
	// functional interface ve stream konusunda effectively final ve final oldukça önemlidir.
	
	// VARARGS: bir metot yalnızca bir tane vararg alabilir. Ve bu vararg en son parametre olmak zorundadır. 
	
	public static void main(String[] args) {
		walkDog(1, 2, 3);
		walkDog(1, new int[] {2, 3});
		walkDog(1); // empty arr oluşur (arr'ın length'i de 0'dır.).
		
		Sample sample = new Sample();
		// sample.floatInWater(); // DOES NOT COMPILE
		
		MethodsAndAccessModifiers m = new MethodsAndAccessModifiers();
		System.out.println(m.str);
		m = null;
		System.out.println(m.str); // null olsa bile çalışır.
		
		m.zooAnimalCheckup(true); // private olsa bile static bir metottan aynı classta iken erişebiliriz.
	
		m.calc((byte) 2); // burada calc(short) metotu çalışacaktır.
		
		m.calc2(2); // burada boxing ile uğraşmak yerine widening (genişletme) işlemini tercih eder.
					// bu yüzden calc2(long) metotu çalışacaktır.
	}
	
	private int calc(int num) {
		return 2 * num;
	}
	
	private int calc(short num) {
		return 2 * num;
	}
	
	private long calc2(Integer num) {
		return num;
	}
	
	private long calc2(long num) {
		return num;
	}
	
	public static void walkDog(int length, int... steps) {
		System.out.println(length + " " + steps.length);
	}
	
	private void fly(int... args) {
	}
	
	// private void fly(int[] args) { } // DOES NOT COMPILE çünkü varargs da zaten bir arraydir.
	
	public void moo(int... i) {
	}
	
	public void moo(int i, int... j) { // LEGAL
	}
}

class Sample extends AccessModifierSample {
	private void swim() {
		this.floatInWater(); // LEGAL
	}
	
	private void swim2() {
		Sample sample = new Sample();
		sample.floatInWater(); // LEGAL
	}
	
	private void swim3() {
		AccessModifierSample sample = new Sample();
		// sample.floatInWater() // DOES NOT COMPILE
	}
	
	private void swim4() {
		AccessModifierSample accessModifierSample = new AccessModifierSample();
		// accessModifierSample.floatInWater(); // DOES NOT COMPILE
	}
}

	// Initializer block'lar birden fazla ise yukarıdan aşağıya doğru çalışırlar.
	// Static initializer blocklar sınıf yüklendiği zaman çalışır.
