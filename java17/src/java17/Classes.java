package java17;

class Insect {
	protected int numberOfLegs = 4;
	String label = "buggy";
}

class Beetle extends Insect {
	protected int numberOfLegs = 6;
	short age = 3;
	
	public void printData() {
		System.out.println(this.label); // buggy
		System.out.println(super.label); // buggy
		System.out.println(this.age); // 3
		// System.out.println(super.age); // DOES NOT COMPILE çünkü super yalnızca bir üst 
																	 // sınıfı temsil eder.
		System.out.println(numberOfLegs); // 6
	}
}

class LittleBeetle extends Beetle {
	protected int numberOfLegs = 8;
	
	public void printData() {
		System.out.println(numberOfLegs); // 8
		System.out.println(super.numberOfLegs); // 6
		System.out.println(((Insect)this).numberOfLegs); // 4
	}
}

public class Classes {	
	// bir constructor başka bir constructor'ı çağırıyorsa (super veya this) bu çağırma her zaman 
	// constructor'ın ilk satırında gerçekleşmelidir. Ve aynı zamanda iki defa çağıramayız.
	
	// constructor'ın biz yazmasak bile ilk satırı super() olur. 
}

class Mammal {
	public Mammal(int age) { }
}

// class Seal extends Mammal { } // DOES NOT COMPILE çünkü super class'ın default constructor'ı ezilmiş.
								 // aynı zamanda Seal sınıfının super class'taki halini karşılayan 
								 // constructor olmadığı için kod compile olmaz. (super'le)