package java17;

import java.io.FileNotFoundException;
import java.io.IOException;

class Camel {
	
	int getNumberOfHumps() throws IOException {
		return 2;
	}
	
	private String get() {
		return "a";
	}
}

class BactrianCamel extends Camel {
	
	@Override
	protected int getNumberOfHumps() throws IOException{ // override ettiği metotun access modifier'ı ile 
		return 2;										 // ya aynı seviye ya da üst seviyeleri olabilir.
		                             					 // private -> package -> protected -> public
	}
	
	private int get() { // -> bu metot override değildir çünkü private access modifier override edilemez.
		return -1;
	}
}

class ThreeHumpsCamel extends Camel {
	
	@Override 
	int getNumberOfHumps() throws FileNotFoundException,
		RuntimeException {                                // fırlattığı exception override ettiği metot ile
		return 3;										  // ya aynı seviye ya da alt seviyeleri olabilir.
	}													  // Veya hiç olmayabilir.				  
														  // Ayrıca unchecked exception da alabilir.
}

public class InitializingMembers {

}

class Rhino {
	protected CharSequence getName() {
		return "rhino";
	}
	
	protected String getColor() {
		return "grey, black, or white";
	}
}

class JavanRhino extends Rhino { 
	@Override 
	protected String getName() { // Metotun dönüş tipi ile override ettiği metotun dönüş tipi ya aynı 
		return "rhino";			 // ya da subclass'ı şeklinde olabilir.
	}
	
	// @Override
	// protected CharSequence getColor() {  // DOES NOT COMPILE
	//	   return "blue";
	// }
}

class Bear {

	public static void laugh() {
		System.out.println("Bear is laughing");
	}
	
	public static void sneeze() {
		System.out.println("Bear is sneezing");
	}
	
	public void hibernate() {
		System.out.println("Bear is hibernating");
	}
	
}

class SunBear extends Bear {
	
	// @Override  // DOES NOT COMPILE çünkü static bir metot override edilemez. Bu sadece yeniden yazma 
	public static void laugh() {   // işlemidir. Super class'ta bulunan static bir metotu subclass sadece
								   // method hiding yapar. Bu olayda yukarıdaki kuralların tümü geçerlidir.
	}
	
	// protected static void laugh() { } // DOES NOT COMPILE çünkü access modifier küçülmüş.
	
	// public void sneeze() { } // DOES NOT COMPILE çünkü static metotu static olmayan bir şekilde override 
								// edemeyiz.
	
	// public static void hibernate() { } // DOES NOT COMPILE üstteki sorunun tam tersi.
}
