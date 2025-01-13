
public class _06_NullCaseInSwitchStatements {
	public static void main(String[] args) {
		System.out.println(getTypeNullable(null));
	}
	
	static String getTypeNullable(Object obj) {
		return switch (obj) {
	    	case Integer i -> i.getClass().getName();
	    	case Long l    -> l.getClass().getName();
	    	case String s  -> s.getClass().getName();
	    	case null      -> "null Type";
	    	default        -> "Unknown";
		};
	}
}
