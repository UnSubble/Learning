package java17;

public class Operators {
	public static void main(String[] args) {
		var cookies = 3;
		int res = 3 + 2 * --cookies; // 3 + (2 * 2) -> 4
		
		var booleanVal = !true; // false
		
		var flipped = ~(0b101110); // -47
		
		int flipped2 = ~15; // -16
		
		short x = 3;
		short y = 10;		
		var result = x + y; // int (2 short aritmetik işleme tabi tutulduğunda inte dönüşür.)
		                         // (bu durum yalnızca değişken kullandığımızda olur.) 
		                         // (ya da işlemin sonucu tipin max veya min valuesunu aşıyorsa 
		                         // derleme hatası verir.)
		
		// byte bytee = 130; // DOES NOT COMPILE
		
		// long l = (long)123456789987456 // DOES NOT COMPILE (sayı int sınırını aştığı için 
		                                                    // casting bir işe yaramaz.)
		
		System.out.println(Integer.MAX_VALUE + 1); // Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
		
		// short z = 1 + (short)(10 * 3) // DOES NOT COMPILE
		
		byte b3 = (byte)(100 + 30); // -126
		
		long sheep = 10L;
		int goat = 5;
		// goat = goat * sheep; // Burada auto-casting yapmaz.
		goat *= sheep; // auto-casting yapar.
		
		byte b1 = 100;
		byte b2 = 30;
		b1 += b2; // -126
		
		boolean healty = false;
		if (healty = true) // burada healty hem true oluyor, hem de geri döndüğünden dolayı if çalışıyor.
			System.out.println("Good!");
		
		boolean b = 'a' == 97; // true
		
		boolean bear = false;
		boolean polar = (bear = true);
		System.out.println(bear); // true
		
		System.out.println(null == null); // true
		
		String str = "a";
		int num = 1;
		// str == num // DOES NOT COMPILE
		
		Integer zooTime = Integer.valueOf(42);
		Integer i = zooTime;
		Object o = zooTime;
		// i == o --> DOES NOT COMPILE
		
		Cat cat = new Cat();
		System.out.println(cat instanceof Object);
		// System.out.println(cat instanceof Flyable); // final ve implement etmediği için compile olmaz.
													   // çünkü cat instance'ı hiçbir implement yapmadığı 
													   // için hiçbir şekilde Flyable instance'ı olamaz.
		
		// System.out.println(null instanceof null); // DOES NOT COMPILE
		System.out.println(null instanceof Object); // false
		
		
		// ----- BITWISE OPERATORS -----
		
		boolean resting = true | true; // true
		boolean bool1 = true & true; // true
		boolean bool2 = true ^ true; // false
		
		// ----- CONDITIONAL OPERATORS -----
		
		boolean bool3 = true;
		boolean bool4 = true;
		boolean r = bool3 && bool4; // true
		r = bool3 || bool4; // true
		
		// ilk sol taraf çalışır:
		// AND ise -> sol taraf yanlışsa sağ tarafı kontrol bile etmez.
		// OR ise -> sol taraf true ise sağ tarafı kontrol bile etmez.
		// bitwise operatorler içinse yanlış veya doğru olmaksızın her ikisini de kontrol eder.
		
		int rabbit = 6;
		boolean bunny = (rabbit >= 6) || (++rabbit <= 7);
		System.out.println(rabbit); // 6
		
		int ter = true ? 1 : 0; // ternary operator
		int owl = 3;
		int food1 = owl < 3 ? owl > 2 ? 3 : 4 : 5; // LEGAL
		
		// int animal = bunny ? 3 : "str"; // DOES NOT COMPILE
		
		int zzz = 1;
		int sleep = zzz < 10 ? zzz++ : owl++;
		System.out.println(zzz); // 2
		
		int pig = 5;
		pig = pig++;
		System.out.println(pig); // 5 --> post-increament işlemi görmezden geliniyor.
		
		// = --> hem değer atar hem de atadığı değeri geri döner.
		
	}
	
	static interface Flyable {
	}
	
	static final class Cat {
	}
}
