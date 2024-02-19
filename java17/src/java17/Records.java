package java17;

public class Records {
// record'larda toString, hashcode ve equals override edilir.
// her değişkene karşılık getter metotu yazılır.
// bütün değişkenleri kapsayan constructor oluşturulur. (Biz başka bir contructor oluşturursak oluşturmaz.
	// Lakin oluşturduğumuz constructor bütün değişkenleri kapsamalıdır.)
// record'lar finaldır yani kalıtamayız.
// record'lar java.lang.Record sınıfını kalıttığı için başka bir sınıfı kalıtamazlar.
// record'larda bütün parametreleri tanımlayan constructor'a canoncial constructor deniyor.	
}

// Compact Constructors..
record Crane(int numberEggs, String name) {
	
	public Crane { // hem compact cobstructor hem de canoncial constructor yazamayız. 
				   // Ama başka constructor tanımlayabiliriz.
		if (numberEggs < 0) 
			throw new IllegalArgumentException();
		
		name = name.toUpperCase(); // gelen parametreyi değiştiriyor. (this. kullanmamak gibi)
								   // bu da final değikene atanır.
	}		
}



record Crane2(int numberEggs, String name) {
	// private final int instance = 6; // DOES NOT COMPILE çünkü static hariç hiçbir değişkene izin vermez.
	// aynı şekilde static initializer block hariç initializer block'lara da izin vermez.
	
	
	//public Crane2() {  // DOES NOT COMPILE çünkü bütün parametreleri tanımlayan constructor'ı çağırmıyoruz.
	//	this.numberEggs = 1;
	//	this.name = "";
	//}
	
	public Crane2() { // LEGAL
		this(1, "");
	}
	
	//public Crane2(int numberEggs) {  // DOES NOT COMPILE çünkü bütün parametreleri tanımlayan 
	//	this.numberEggs = 1;                         // constructor'ı çağırmıyoruz.
	//	this.name = "";
	//}
	
	public Crane2(String name, int numberEggs) {
		this(numberEggs, name);  // Yerleri bile değişse canoncial constructor'ı çağırmamız gerekir.
		numberEggs = 5; // NO EFFECT
		// this.numberEggs = 5; // DOES NOT COMPILE çünkü final değişken
	}
}
