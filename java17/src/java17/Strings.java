package java17;

import java.util.Locale;

public class Strings {

	public static void main(String[] args) {
		System.out.println("c" + null); // cnull
		System.out.println(1 + 2 + "c"); // 3c
		System.out.println("c" + 1 + 2); // c12
		
		var s = "1";
		s += "2";
		s += 3; // 123
		
		var temp = "\t"; // length() -> 1
		
		System.out.println("asdasd".indexOf('a', 3)); // 3
		
		System.out.println("asdasd".substring(3,3)); // empty string
		
		String content = "injavawetrust";
		char[] charArr = new char[4];
		content.getChars(2, 6, charArr, 0); // java
		
		System.out.println("\t   a b c\n".strip()); // a b c
		
		System.out.println("\t   a b c\n".trim()); // a b c 
		
		// trim ve strip'in tek farkı strip'in unicode karakterleri de destekliyor olmasıdır.
		
		System.out.println("aa".indent(2)); // "  aa\n"
		System.out.println("  aa".indent(-1)); // " aa\n"
		
		// indent \n olmayan satırlara \n ekler. Ve girdiğimiz sayı kadar stripLeading() yapar.
		
		System.out.println(""" 
				  a
				 b
				  c
				""".indent(-1).length()); // 8
		
		System.out.println((" a\n" +
						   "  b\n" +
						   " c").stripIndent()); // Bütün satırlardaki ortak boşluk sayısı kadar siler.
												 // \n eklemez. Sonuncu satırda \n varsa alt satır var 
												 // demektir. Ve bu alt satır 0 tane boşluklu olacaktır.
		
		String str = "1\\t2";
		System.out.println(str.translateEscapes()); // "1    2"
		System.out.println("1\\n2".translateEscapes()); // "1
														//  2"
		
		System.out.println("".isEmpty()); // true
		System.out.println(" ".isEmpty()); // false
		System.out.println("".isBlank()); // true
		System.out.println(" ".isBlank()); // true
		System.out.println("     ".isBlank()); // true
		
		System.out.println(String.format("%s %s is my name.", "ali", "baba"));
		System.out.println("%s %s is my name.".formatted("ali", "baba"));
		
		double pi = 3.14159265359;
		System.out.format(Locale.ENGLISH, "%f\n", pi); // 3.141593 (rounding de yapar.)
		System.out.format(Locale.ENGLISH, "%12.8f\n", pi); // " 3.14159265"
		System.out.format(Locale.ENGLISH, "%012f\n", pi); // 00003.141593
		System.out.format(Locale.ENGLISH, "%12.2f\n", pi); // "       3.14"
		System.out.format(Locale.ENGLISH, "%.3f\n", pi); // " 3.142"
		
		String x = "Hello";
		String y = "Hello";
		String z = new String("Hello");
		String t1 = "He";
		String t2 = "llo";
		String t = t1 + t2;
		String trim = " Hello";
		trim = trim.trim();
		String t5 = "He" + "llo";
		
		System.out.println(x == y); // true
		System.out.println(x == z); // false
		System.out.println(t == x); // false
		System.out.println(trim == x); // false
		System.out.println(t5 == x); // true
		System.out.println(x.equals(z)); // true
		System.out.println(x.equals(t)); // true
		System.out.println(x.equals(trim)); // true
		
		String fullMsg = "hello world";
		final String msg1 = "hello";
		final String msg2 = " world";
		String msg3 = msg1 + msg2;
		System.out.println(fullMsg == msg3); // true
		
		Strings cls = new Strings();
		final String msg4 = cls.helloMsg();
		final String msg5 = cls.worldMsg();
		String msg6 = msg4 + msg5;
		System.out.println(msg6 == fullMsg); // false
		
		String name = new String("hello world").intern();
		System.out.println(name == fullMsg); // true
		
		
	}
	
	final String helloMsg() {
		return "hello";
	}
	
	final String worldMsg() {
		return " world";
	}

}
