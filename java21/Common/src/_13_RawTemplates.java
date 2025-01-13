import static java.lang.StringTemplate.RAW;

void main() {
	int x = 10, y = 20;
	@SuppressWarnings("preview")
	StringTemplate s = RAW."\{x} + \{y} = \{x + y}";
	System.out.println(s);
	
	String str = STR.process(s);
	System.out.println(str);
}
