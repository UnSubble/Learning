import java.lang.reflect.Modifier;

// unnamed class oluşuyor. Bu final class <DOSYA_ISMI> olarak oluşuyor.

// İlk önce arg alan main metodu çalışıyor.

// static main method with args > non-static main method with args > non-static main method without args

void main(String[] args) {
	
	System.out.println("Is class unnamed? " + getClass().isSynthetic()); // normalde true gelmesi lazım.
                                                                        // sürümden dolayı false geliyor.
	
	test();
	
	System.out.println();
	System.out.println("---------------------------");
	System.out.println();
	
	System.out.println(this.getClass());
	System.out.println(this.getClass().getCanonicalName() + "'s Modifiers: " + 
					Integer.toBinaryString(this.getClass().getModifiers()));
	System.out.println("Final: " + Integer.toBinaryString(Modifier.FINAL));
	System.out.println("Public: " + Integer.toBinaryString(Modifier.PUBLIC));
}

void main() {
	System.out.println("Hello, Java 21!");
}

void test() {
	System.out.println("test method from unnamed class!");
}