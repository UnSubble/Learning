package java17;

interface Climb {
	Number getSpeed(int age);
}

interface CanBurrow {
	Float getSpeed(int age);
}

class FieldMouse implements Climb, CanBurrow {

	@Override
	public Float getSpeed(int age) {
		return 1f;
	}
	
	// @Override
	// public Number getSpeed(int age) { // DOES NOT COMPILE
	//	return 1f;
	//}
	
}

public class Interfaces {
	// Interface'in kendisi biz yazmasak bile abstract'tır.
	// Interface'in bütün değişkenleri biz yazmasak bile public static final'dır.
	// Interface'in bütün metotları biz yazmasak bile public abstract'tır. 
	// Interface'te statik metotlar abstract değildir. Ama public'tir. (Statik metotu çağırmak istediğimizde
															// yalnızca interface'in ismi ile çağırabiliriz.)
	// Ayrıca interface içinde private veya private static metot tanımlayabiliriz.
	// Interface'in default metotları abstract, static, final olamazlar.
}

interface Omnivore {
	void eatPlants();
}

interface Herbivore {
	void eatPlants();
}

class Animal implements Omnivore, Herbivore { // Interfacelerin metotlarının bir tanesinin dönüş tipi 
											  // farklı olsaydı bu class compile edilemezdi.
	@Override
	public void eatPlants() {
	}
	
}