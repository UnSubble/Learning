package java17;

enum Season {
	SPRING,
	SUMMER,
	FALL(),
	WINTER();
	
	// private static n = 0; // DOES NOT COMPILE çünkü static variable'ı olamaz.
	
	public static void make() { // LEGAL
	}
	
	private Season() { // zaten private'tır. Access modifier yazmaya gerek yoktur.
		System.out.println(this.name());
	}
}

public class Enums {
	public static void main(String[] args) {
		System.out.println(Season.SPRING); // ilk yüklendiği yerde hepsi tanımlanır. Bu yüzden enum'ın bütün
										   // değerleri için constructor çalışır.
		System.out.println(Season.FALL); // SPRING, SUMMER, FALL, WINTER, SPRING, FALL
	}
	
	// enum'lar java.lang.Enums extends ettikleri için başka bir class'ı extends'leyemezler.
}

enum Season2 {
	WINTER {
		public String getMonths() { return "12,1,2"; }
	},
	SPRING {
		public String getMonths() { return "3,4,5"; }
	},
	SUMMER {
		public String getMonths() { return "6,7,8"; }
	},
	FALL {
		public String getMonths() { return "9,10,11"; }
	};
	
	public abstract String getMonths();
}

enum Season3 {
	WINTER {
		public String getMonths() { return "12,1,2"; }
	},
	SPRING {
		public String getMonths() { return "3,4,5"; }
	},
	SUMMER,
	FALL;
	
	public String getMonths() {
		return null;
	}
}
