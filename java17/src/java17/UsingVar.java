package java17;

public class UsingVar {
	public static void main(String[] args) {
		var name = "legal";
		var size = 7;
		var silly = 
				"legal";
		// var sadece local değişkenlerde kullanılır.
		
		//var answer;
		//if (true) {
		//	answer = 2;
		//} else {
		//	answer = 32;
		//} 
		// var tanımlandığı yerde initialize olmalıdır.
		
		// var n = null // DOES NOT COMPILE
		// int a, var b = 3; // DOES NOT COMPILE
		
		// var e = 10, f = 30; // DOES NOT COMPILE
		
		var str = (String) null; // LEGAL
		
		// var bir keyword değildir, rezerve bir tiptir. 
		// yani değişken, metot isminde kullanabiliriz.
		var var = 5; // LEGAL
		// var ismi class, interface, enum için kullanılamaz. 
		// (ilk harfi büyük Var kullanılabilir)
		// package'larda kullanılabilir.
		
		var s = 10;
		// s = null; // DOES NOT COMPILE
	
	}
	
	// DOES NOT COMPILE
	// public int add(var a, var b) {
	// 	   return a + b;
	// }
}
