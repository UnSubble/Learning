package java17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

interface MyInterface {
	boolean perform(String str);
}

class LambdaTest {
	
	void print(MyInterface mi) {
		System.out.println(mi.perform("alphabet"));
	}
}

public class LambdasAndFunctionalInterfaces {
	
	// illaki @FunctionalInterface olmasına gerek yoktur.
	// içinde bir tane abstract metot bulunan interface yeterlidir.
	// toString(), equals(), hashcode() gibi object'ten gelen metotlar functional interface'te geçerli 
	// değildir.
	
	public static void main(String[] args) {
		new LambdaTest().print(x -> x.startsWith("a"));
		
		// var invalid = (String x) -> x.startsWith("a"); // DOES NOT COMPILE çünkü var ne 
															// döneceğini algılayamıyor.
		
		Consumer<Integer> consumer = (var x) -> System.out.println(x); // var kullanabiliriz.
		
		List<Integer> list = new ArrayList<>(); 
		list.sort((final var x, @Deprecated var y) -> x.compareTo(y)); // final @Deprecated kullanabiliriz.
													// Desteklenen annotationların hepsini kullanabiliriz.
		
		// BiFunction<Integer, String, Integer> func = 
		//		(Integer x, y) -> Integer.parseInt(y) + x; // DOES NOT COMPILE bir tanesi tanımlanmışsa 
															// diğerinin de tanımlanması gerekir.
		
		// BiFunction<Integer, String, Integer> func =
		//		(Integer x, var y) -> Integer.parseInt(y) + x; // DOES NOT COMPILE çünkü bir tip belirtilip
															// diğeri var olamaz.
		
		BiFunction<Integer, Integer, Integer> func =
				(x, y) -> {int z = 0; return x + y + z; };
		
		
	}
	
	private String color;
	private static int size = 5;
	
	public void caw(String name) {
		String volume = "loudly";
		Consumer<String> consumer = s -> System.out.println(name + " says " + volume + size +
				" that she is " + color); // Eğer değişkenler effectively final veya final ise lambdada 
		// name = "a"; // eğer yorumdan kaldırılırsa üstteki lambda compile hatası verir.																				// kullanılabilir.
	}
}

@FunctionalInterface
interface Climb1 {
	void reach();
	
	default void fall() {
	}
	
	private int getHeight() {
		return 100;
	}
	
	boolean equals(Object o);
}
