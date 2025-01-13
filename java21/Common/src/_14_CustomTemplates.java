void main() {
	StringTemplate.Processor<String, RuntimeException> TEST = StringTemplate.Processor.of(t -> {
		StringBuilder sb = new StringBuilder();
		for (Object str : t.values()) {
			sb.append(str).append(" ");
		}
		sb.append(31);
		return sb.toString();
	});
	
	int x = 10, y = 20;
	@SuppressWarnings("preview")
	String s = TEST."\{x} + \{y} = \{x + y}";
	
	System.out.println(s);
}
