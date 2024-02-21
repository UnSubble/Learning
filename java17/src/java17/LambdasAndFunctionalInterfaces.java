package java17;

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
