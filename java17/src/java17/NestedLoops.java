package java17;

public class NestedLoops {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		OUTER_LOOP: // label olarak adlandırılıyor.
			for (int[] arr : matrix) {
				INNER_LOOP:
					for (int c : arr) {
						System.out.print(c + "\t");
					}
				System.out.println();
			}
		
		int frog = 15;
		BAD_IDEA: if (frog > 10) // böyle bile kullanabiliriz. Lakin bu kötü bir kullanımdır.
		EVEN_WORSE_IDEA: {
			frog++;
		}
		
		OUTER: // label olarak adlandırılıyor.
			for (int[] arr : matrix) {
				INNER:
					for (int c : arr) {
						System.out.print(c + "\t");
						break OUTER; // label ile break yapabiliyoruz.
					}
				System.out.println();
			}
		
		LOOP:
			for (int i = 0; i < 10; i++) {
				System.out.print(i + "\t");
				break LOOP; // label ile break yapabiliyoruz.
			}
		System.out.println();
		
		// bu label'lar continue ifadesi için de geçerlidir.
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "\t");
			break;
			// System.out.println("sample"); // DOES NOT COMPILE (continue ve return için de geçerlidir)
		}
		
		
		
	}
}
