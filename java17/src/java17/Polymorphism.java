package java17;

interface CanSwim {
	
}

class BadWolf implements CanSwim {
}

class Dog implements CanSwim {
}

final class BabyWolf extends BadWolf {
}

public class Polymorphism {
	// Static method ve instance değişkenler (static olmasa da olur) için referans türü önemlidir.
	// Static olmayan metotlar içinse objenin tipi önemlidir.
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		CanSwim can = dog;
		// BadWolf wolf = (BadWolf) can; // ClassCastException
		
		BadWolf wolf2 = new BadWolf();
		// if (wolf2 instanceof Dog) {} // DOES NOT COMPILE
	}
}
