package java17;

public class StringBuilderImportants {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("adfasdf"); // mutable olduğu için atamaya gerek yok.
		sb.delete(4, 100); // LEGAL
		sb.delete(3, 5).deleteCharAt(2);
		sb.append("sfdasdsafdsaf");
		sb.replace(7, 100, ""); // LEGAL
		
		StringBuilder var1 = new StringBuilder("Hello World");
		StringBuilder var2 = new StringBuilder("Hello World");
		System.out.println(var1.equals(var2)); // false Çünkü StringBuilder sınıfı equals metodunu override
											   // etmemiştir.
		
		String var3 = "Hello World";
		// System.out.println(var3 == var1); // DOES NOT COMPILE çünkü objelerin tipi farklı
	}
}
