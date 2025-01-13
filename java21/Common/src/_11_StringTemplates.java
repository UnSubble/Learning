@SuppressWarnings("preview")
void main() {
	int x = 10, y = 20;
	String s = STR."\{x} + \{y} = \{x + y}";
	System.out.println(s);
	
	System.out.println(STR);
	
	String s2 = STR."\{x} == \{x == 10 ? y : 10}";
	System.out.println(s2);
	
	// String s3 = STR."\{System.out.println(x)}"; // -> IDE hata veriyor.
	// System.out.println(s3);
	
	String s4 = STR."\{
			// Comment line
			x}";
	System.out.println(s4);
	
	System.out.println(STR."\{x++}, \{x++}, \{x++}, \{x++}");
	
	String[] fruits = {"apple", "banana", "strawberry", "melon"};
	System.out.println(STR."fruits: \{fruits[0]}, \{STR."\{fruits[1]}, \{fruits[2]}"}");
	
	String block = STR."""
			fruits: 
			\{fruits[0]}
			\{fruits[1]}
			\{fruits[2]}
			""";
	System.out.println(block);
}