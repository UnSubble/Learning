package java17;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class AnnotationsIntroduction {
	// annotation'ların metotlarında primitive tipler, String, enum, Class<?>, başka
	// bir annotation ve bunların bir boyutlu array hali harici değerler
	// kullanılamaz.

	@SampleAnnotation2("help")
	public static void main(String[] args) {
		Object obj = "test";
		String s = (@SampleAnnotation String) obj;

	}
	
	// Bir annotation'a @Repeatable annotation'ı verdiğimizde 
	// aynı element üzerinde birden çok kez kullanabiliriz.
}

@Target(ElementType.TYPE_USE)
@interface SampleAnnotation {
	Integer MIN = Integer.MIN_VALUE;
	int MAX = Integer.MAX_VALUE;

	// int minNum() default MIN; // DOES NOT COMPILE (tip dönüşümü olmuyor.)
	int maxNum() default MAX;
}

// eğer annotation'ın içinde ismi value olan sadece bir tane 
// metot varsa ismini belirtmeden bu metodu kullanabiliriz. 
// ayrıca required olan başka bir metot da olmamalı.
@Target(ElementType.METHOD)
@interface SampleAnnotation2 {
	String value(); // default'u da olabilir. Sorun olmaz.
	String scndMethod() default "";
}