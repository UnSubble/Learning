interface Fly {
	int getWingSpan();
	
	default void land() {
		System.out.println("Animal is landing");
	}
	
	static int calculateSpeed(int n, int m) {
		return n * m;
	}
}

interface Bird {
	default void land() {
		System.out.println("Animal is dfasgdfs");
	}
}

interface Deneme {
	int getWingSpan();
}

// interfacelerde iki tane default ve aynı türde metot varsa bu diamond problem'a yol açar.
// mutlaka 1 tanesini override etmemiz gerekir.
class Eagle implements Fly, Bird {

	@Override
	public int getWingSpan() {
		return 31;
	}

	@Override
	public void land() {
		Bird.super.land();
	}
	
}

// Burada sorun çıkmaz, her zaman class > interface olur. bu yüzden classtan gelen metot 
// interfaceteki metotu ezer.
class Pigeon extends Eagle implements Deneme {
	
}


public class Interfaces {
	public static void main(String[] args) {
		Fly fly = new Eagle();
		fly.land();
		fly.getWingSpan();
		// fly.calculateSpeed(4,5); interface'teki static metota böyle erişemeyiz.
	}
}
