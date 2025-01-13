import static java.util.FormatProcessor.FMT;

record Rectangle(String n, double w, double h) {
	double a() {
		return w * h;
	}
}

void main() {
	Rectangle[] zone = new Rectangle[] {
			new Rectangle("Alfa", 17.8, 31.4),
			new Rectangle("Bravo", 9.6, 12.4),
			new Rectangle("Charlie", 7.1, 11.23)
	};
	
	@SuppressWarnings("preview")
	String table = FMT."""
			Name        Width        Height        Area
			%-11s\{zone[0].n()} %-12.2f\{zone[0].w()} %-13.2f\{zone[0].h()} %-11.2f\{zone[0].a()}
			%-11s\{zone[1].n()} %-12.2f\{zone[1].w()} %-13.2f\{zone[1].h()} %-11.2f\{zone[1].a()}
			%-11s\{zone[2].n()} %-12.2f\{zone[2].w()} %-13.2f\{zone[2].h()} %-11.2f\{zone[2].a()}
			""";
	
	System.out.println(table);
}