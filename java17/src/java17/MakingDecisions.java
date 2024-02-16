package java17;

import java.util.List;

public class MakingDecisions {
	public static void main(String[] args) {
		Number a = 15;
		if (a instanceof Integer b) { // Pattern-matching...
			System.out.println(b.doubleValue());
			b = 35;
		}
		
		if (a instanceof final Integer b) {
			System.out.println(b.doubleValue());
			// b = 35; // DOES NOT COMPILE
		}
		
		if (a instanceof Integer b && b.compareTo(5) > 0) {
			System.out.println(b.byteValue());
		}
		
		if (a instanceof List b) {		
		}
		
		Integer c = 15;
		if (c instanceof Integer b) { // DOES NOT COMPILE çünkü soldaki ifade sağdakinin subtype'ı değil.
		}							// Bu olay java 17 için geçerli bir şey. İleri sürümlerde düzelmiş.
		if (a instanceof Number b) {
		}
		
		// if (a instanceof Integer data || data.compareTo(5) > 0) // DOES NOT COMPILE
								// çünkü sol taraf false olduğunda sağ taraftaki değişken hiç olmayacak.
		
		if (!(a instanceof Integer data))
			return; // buraya a Integer olmadığında girdiğinden dolayı data değişkeni yoktur.
		else // else bloğu olsa da olmasa da alttaki çalışır.
			System.out.println(data.intValue()); // if statement zaten her türlü kontrol edileceği için 
												// bu kullanım legaldir.
		
		int num = 3;
		switch (num) {
			case 1:
				break;
			case 3, 4: // 3 || 4 anlamında
				break;		
		}
		
		// switch statement'ında long, float, boolean ve double ifadeleri kullanılamaz.
		
		final int bananas = 1;
		int apple = 2;
		final int cookies = getCookies();
		
		switch(num) {
			case bananas:
				break;
			case 3 * 5:
				break;
			// case apple: // DOES NOT COMPILE çünkü sadece constant ve final değerler kullanılabiliyor.
			// case getCookies: // DOES NOT COMPILE -> metot da çağırılamaz.
			// case cookies: // DOES NOT COMPILE -> metot çağıran değişken final olsa bile kullanılamaz.
		}
		
		// ----- SWITCH EXPRESSION -----
		int result = switch (num) {
			case 4 -> 3;
			case 3,5 -> {
				System.out.println("sample");
				yield 7;  // yield keyword'ü sadece case bloklarda kullanılıyor.
				// System.out.println("sample 2"); // DOES NOT COMPILE
			}
			case 6 -> (short)2;
			// case 7 -> 2L; // DOES NOT COMPILE
			case 8 -> {
				yield 9;
			}
			default -> 30;
		}; // default branch bu switch statement'ında zorunludur.
		
		// eğer switch expression ifademiz enum'sa enum'daki
		// bütün değerleri aldığında default kullanmayabiliriz.
		
		switch (num) {
			case 1 -> System.out.println("sample"); // geriye değer dönmeyebilir.
		}
		
		// for (int i = 5, long j = 10L; i < 19; i++) // DOES NOT COMPILE
													// tanımladığımız değişkenler aynı tipte olmalıdır.
													// (tıpkı declaringAValue dersindeki gibi)
		
		while (num < 5) {
		}
		
		System.out.println("reachable"); // sonsuz loop olsa bile kabul ediyor nedense.
										// ama num < 5 yerine true olsaydı compile hatası verirdi.
		
		do System.out.println(5);
		while (num < 5);          // tek satır burada da legal
		
		//do {
		//    int snake = 0;
		//} while (snake > 5); // DOES NOT COMPILE
		
		while (true) {
		}
		
		// System.out.println(); // DOES NOT COMPILE çünkü true'nun asla bitmeyeceği 
								// java tarafından biliniyor.
		
	}
	
	static final int getCookies() {
		return 4;
	}
	
	static final int get(final int num) {
		int n = 0;
		switch(n) {
			// case num: // DOES NOT COMPILE
		}
		return n;
	}
}
