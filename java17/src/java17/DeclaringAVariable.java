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
		
		// İlk önce class seviyesindeki değişkenler initialize edilir. Daha sonra initializer block'lar (
		// yalnızca gövdesi olan static{ } gibi olan bloklar) çalışır. Sonrasında constructor çalışır.
	}
}
