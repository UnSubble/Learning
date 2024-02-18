package java17;

public class DeclaringAVariable {
	public static void main(String[] args) {
		String $test = "legal";
		// String _ = "legal değil";
		String €uro = "legal";
		String ßÜ7£ = "legal";
		// int num, String val; // DOES NOT COMPILE
		int a,b,c= 0; // LEGAL ve bir tek c initialize edilmiş.
		
		Integer.valueOf("42"); // Integer döner.
		Integer.parseInt("42"); // int döner.
		
		// int f = c * (long) c; // DOES NOT COMPILE çünkü long * int = long
		
		// İlk önce class seviyesindeki değişkenler initialize edilir. Daha sonra initializer block'lar (
		// yalnızca gövdesi olan static{ } gibi olan bloklar) çalışır. Sonrasında constructor çalışır.
		
		// Long d = 8; // DOES NOT COMPILE çünkü hem type casting hem de autoboxing yapmaz.
		Integer e = 8;
		long f = e; // LEGAL çünkü hem unboxing hem de implicitly cast yapar.
		
		Integer i1 = 100;
		Integer i2 = 100;	
		System.out.println(i1 == i2); // true
		System.out.println(i1.equals(i2)); // true
		
		Integer i3 = 1000;
		Integer i4 = 1000;
		System.out.println(i3 == i4); // false çünkü bir cachepool var ve bu java.lang.Integer.IntegerCache
									  // sınıfındaki low ve high değişkenleri ile belirleniyor. Bunu 
									  // çalıştırırken komut girerek değiştirebiliriz.
		System.out.println(i3.equals(i4)); // true
	}
}
