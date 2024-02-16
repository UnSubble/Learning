package java17;

import java.util.Arrays;

public class TextBlock {
	public static void main(String[] args) {
		String text = """
				Bu string 
				    çok satırlı 
				3. satır
				"""; // Java 15 ile geldi. Okumayı kolaylaştırma amacı ile
		// Baştaki boşluklar zorunlu ve java tarafından okunmayanlardır.
		// Text'in 2. satırındakiler ise isteğe bağlı ve java tarafından okunarak konsola yazılır.
		// Zorunlu boşluklar kapatıcı 3 tırnağın solundakilerdir.
		System.out.println(text);
		System.out.println("""
			\"""  
			"""); // kaçış karakteri ile de kullanılabilir.
		System.out.println("""
				line1
				line2 \
				line3
				line4
				"""); // --> kaçış karakteri \n iptali yapıyor.
		/// """doe"""; // DOES NOT COMPILE (text blokta 3 tırnak açılan satıra yazı yazılamaz.)
		System.out.println("""
				deneme
				deneme"""); // burada 3 tırnaktan sonra yazı yazılmadığı için kullanım legaldir.
		
		String block1 = """
				a""";
		System.out.println(block1.length()); // -> 1
		System.out.println(Arrays.toString(block1.toCharArray())); // [a]
		
		String block2 = """
				a
				""";
		System.out.println(block2.length()); // -> 2
		System.out.println(Arrays.toString(block2.toCharArray())); // [a, \n]
		
		String block3 = """
				a\n
				""";
		System.out.println(block3.length()); // -> 3
		System.out.println(Arrays.toString(block3.toCharArray())); // [a, \n, \n]
		
		String block4 = """
					line1
				line2
				 		line3 """;
		System.out.println(block4);
	}
}
