package java17;

import java17.OuterClass.Colors;

public class NestedClassesAndInterfaces {
	// Nested classlar abstract ya da final olabilir.
	
	// Inner class'lar public, protected, package, private olabilir.
	// Üst class'ın private üyelerine bile erişim sağlayabilir. Üst class da bu class'ınkilere erişim 
																								// sağlar.
	// Java11'den önce inner class'larda static member kullanamıyorduk. Artık kullanabiliyoruz.
	// Kod compile olduğunda Home.class ve Home$Room.class oluşur.
	
	// Static class'lar outer class'ın (üst class'ın) değişkenlerine direkt erişim sağlayamaz.
	
	
	public static void main(String[] args) {
		Home.Room room = new Home().new Room(); // LEGAL
		Home home = new Home();
		Home.Room room2 = home.new Room(); // LEGAL
		
		OuterClass.Colors color = Colors.RED;
		
		Park.Ride ride = new Park.Ride();
		// Park.Ride ride2 = new Park().new Ride(); // DOES NOT COMPILE
		
		NoName nameless = new NoName() {
		};		
		System.out.println(nameless.getClass()); // class java17.NestedClassesAndInterfaces$1 (ismi yok.)
	}
}

class Home {
	private String msg = "entered";
	
	class Room {
		private static int roomCount = 5;
		
		public void enter() {
			System.out.println(msg);
		}
	}
	
	int getRoomCount() {
		return Room.roomCount;
	}
}



class OuterClass {
	static record Person(String name, String surname) { // inner record'lar biz yazsak da yazmasak da 
	}													// static tanımlanırlar.
	
	static enum Colors { // inner enum'lar da biz yazsak da yazmasak da static tanımlanırlar.
		RED, BLUE, YELLOW
	}
}



class Fox {
	private int x = 15;
	
	private class Den {
		private int x = 30;
		
		void getX() {
			int x = 45;
			System.out.println(x); // 45
			System.out.println(this.x); // 30
			System.out.println(Fox.this.x); // 15
		}
	}
	
	public void goHome() {
		new Den();
	}
	
	public static void visitFriend() {
		// new Den(); // DOES NOT COMPILE çünkü static, doğrusu -> new Fox().new Den();
	}
}



class Park {
	private int price = 10;
	private static int price2 = 20;

	static class Ride {
		private static int price = 6;
		private int price2 = 12;
		
		static void getPrice() {
			System.out.println(price); // 6
			System.out.println(Park.price2); // 20
		}
	}
	
	void getPrice() {
		System.out.println(price);
		System.out.println(Ride.price); // LEGAL
		Ride ride = new Ride();
		System.out.println(ride.price2); // LEGAL
	}
}

class OuterClass2 {
	public void make() {
		final int height = 5;
		int width = 10;
		int length = 15;
		
		class LocalClass { 
			public int multiply() {
				return height * width; // effectively final ve final değişkenler kullanılabilir.
			}
			
			public int multply2() {
				// return height * width * length; // DOES NOT COMPILE final olmayan değişken kullanıldığı
				return -1;																	// için.
			}
		}
		
		length = 30;
	}
	
	// NEDEN final olmayan değişkenlere ulaşılamıyor? çünkü java inner class'lar için de .class dosyası
	// oluşturur ve bundan dolayı hiçbir değişkene erişemez. Final değişkenler için de pass by value yapar.
	// Bu yüzden local class'ta final değişkenler kullanılabilirler. 
}



class OuterClass3 {
	private int s = 15;
	
	public void calc() {
		interface LocalInterface {
			void area();
		}
		
		// LocalInner localInner = new LocalInner(); // DOES NOT COMPILE çünkü localinner class'ı daha 
																						// tanımlanmadı.
		class LocalInner implements LocalInterface {
			private int s = 30;

			@Override
			public void area() {
				System.out.println(s); // 30
				System.out.println(this.s); // 30
				System.out.println(OuterClass3.this.s); // 15
			}
		}
		
		enum Color {
			RED, GREEN, BLUE
		}
		
		record Rec(String name) {
		}
		
		// Sealed class tanımı yapılamıyor.
	}
}



class ZooGiftShop {
	abstract class SaleTodayOnly {
		abstract int dollarsOff();
	}
	
	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			
			@Override
			int dollarsOff() {
				return basePrice * 3;
			}
		};
		
		return sale.dollarsOff();
	}
}



abstract class NoName {
}



class OyterClass4 {
	public void method(int num) {
		class LocalClass {
			protected int size = 3;
			
			public void overrideMe() {
				System.out.println("local class");
			}
		}
		
		LocalClass anonim = new LocalClass() {
			@Override
			public void overrideMe() {
				System.out.println("anonymous class " + size + num); // anonymous class 3{num}
			}
		};
	}
}
