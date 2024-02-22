package java17;

import java.util.Comparator;

class Person {
	int id;
	String name;
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}

public class ComparatorInterface {
	public static void main(String[] args) {
		Comparator<Person> comp = Comparator.comparing(Person::getName).thenComparingInt(Person::getId);
		// ilk önce isme göre karşılaştırıyor. Daha sonra id'ye göre.
		
		Comparator<Person> cmp = Comparator.comparing(Person::getName).reversed();
		// isme göre karşılaştırıp tersini alıyor.
	}
}
