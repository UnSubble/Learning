import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("1","2","3","4","5").peek(i -> System.out.print(i + " ")); 
		// intermediate metot olduğu için terminal operation alana kadar çalışmaz. Lazy davranır.
		s.forEach(x -> System.out.print(x + " "));
		// şu an çalışır
		// terminal operation'dan sonra stream kapanır. Bir daha kullanamayız. 
		// Kullanmaya çalışırsak exception fırlatır.
		
		System.out.println("\n\n\n");
		
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4));
		list.stream().flatMap(x -> x.stream()).toList().forEach(System.out::println);
	}
}
