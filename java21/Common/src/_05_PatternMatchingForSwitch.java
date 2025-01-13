
public class _05_PatternMatchingForSwitch {
	public static void main(String[] args) {
		System.out.println(getTypeName(15L));
	}
	
	static String getTypeName(Object obj) {
		return switch (obj) {
		    case Integer i -> i.getClass().getName();
		    case Long l    -> l.getClass().getName();
		    case String s  -> s.getClass().getName();
		    default        -> "Unknown";
		};
	}
}
