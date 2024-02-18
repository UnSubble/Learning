package java17;

abstract class Bee {
	// public abstract static void make(); // DOES NOT COMPILE
	// public abstract final void set(); // DOES NOT COMPILE
	// private abstract void talk(); // DOES NOT COMPILE
	abstract public void say(); // LEGAL
	abstract CharSequence get();
}

class Queen extends Bee {

	@Override
	public void say() {		
	}

	@Override
	String get() { // LEGAL (normal initialize yöntemlerinin hepsi geçerlidir.)
		return "Walter";
	}
	
	// public abstract queenMethod(); // DOES NOT COMPILE
}

public class AbstractClasses {

}
