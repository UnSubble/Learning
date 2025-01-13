
public class _07_Guard {
	public static void main(String[] args) {
		testStringBefore21(":)");
		testStringAfter21(":)");
	}

	static void testStringBefore21(Object obj) {
		switch (obj) {
		case null -> {
		}
		case String s -> {
			if (s.equalsIgnoreCase("test"))
				System.out.println("TEST!");
			else if (s.equalsIgnoreCase("test2"))
				System.out.println("TEST 2!");
			else
				System.out.println(":(");
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + obj);
		}
	}

	static void testStringAfter21(Object obj) {
		switch (obj) {
		case null -> {
		}
		case String s when (s.equalsIgnoreCase("test")) -> System.out.println("TEST!");
		case String s when (s.equalsIgnoreCase("test2")) -> System.out.println("TEST 2!");
		case String s -> System.out.println(":(");
		default -> throw new IllegalArgumentException("Unexpected value: " + obj);
		}
	}
}
