package java17;

public class MethodOverloadingAdvanced {
	
	public static String calc(int i, int j) {
		return "1";
	}
	
	public static String calc(int i, long j) {
		return "2";
	}
	
	public static String calc(long i, int j) {
		return "3";
	}
	
	public static String calc(Integer i, Integer j) {
		return "4";
	}
	
	public static String calc(long i, long j) {
		return "5";
	}	
	
	public static String calc(Integer i, long j) {
		return "6";
	}

	public static void main(String[] args) {
		System.out.println(calc(1, 2)); // 1
		// System.out.println(calc(1, Integer.valueOf(2))); // DOES NOT COMPILE
		System.out.println(calc(Integer.valueOf(1), Integer.valueOf(2))); // 4
		System.out.println(calc(3, 4L)); // 2
		System.out.println(calc(Integer.valueOf(2), 2L)); // 6
		System.out.println(calc(2, 2)); // Eğer 1 dönen calc() metotu olmasaydı 2 ve 3 dönen calc() metotları
										// aynı önceliğe sahip olduğu için compile olmayacaktı.
		
		System.out.println(calc("a")); // 1
		System.out.println(calc("a", "b")); // 2
		System.out.println(calc("a", "b", "c")); // 3
	}
	
	public static String calc(String i) {
		return "1";
	}
	
	public static String calc(String i, String j) {
		return "2";
	}
	
	public static String calc(String... i) {
		return "3";
	}

	public static String calc(Object i) {
		return "4";
	}
}
