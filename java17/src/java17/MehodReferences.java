package java17;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class MehodReferences {
	// Metot referanslarında yalnızca statik metotları class ismi ile instance metotları da instance'ı ile 
																							// çağırabiliriz.
	// Class::Method (sonunda parantez yok.)
	
	public static void main(String[] args) {
		var str = "";
		Predicate<String> pre = String::isEmpty; // burada instance metotu static metot gibi vermiş 
												// gözüküyoruz. Fakat String class'ı yerine değişken geçiyor.
		pre.test(str);
		
		Supplier<Boolean> supp = str::isEmpty;
		
		Predicate<String> presc = Helper::staticCheck;
		Predicate<String> prec = new Helper()::check;
		// Predicate<String> pred = Helper::check; // DOES NOT COMPILE çünkü statik olmayan bir metota 
																	// erişmeye çalışıyoruz.
	}
}

class Helper {
	boolean check(String str) {
		return str.isEmpty();
	}
	
	static boolean staticCheck(String str) {
		return str.isEmpty();
	}
}
