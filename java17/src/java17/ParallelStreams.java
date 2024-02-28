package java17;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {
	public static void main(String[] args) {
		// stream üzerinde isParallel() metotu var. Paralelliği destekliyorsa true aksi halde false döner.
		
		IntStream stream = IntStream.rangeClosed(1, 20);
		stream.parallel().forEach(System.out::println);
		
		IntStream stream2 = IntStream.rangeClosed(1, 20);
		stream2.parallel().mapToObj(x -> Thread.currentThread().getName()).forEach(System.out::println);
		
		IntStream stream3 = IntStream.rangeClosed(1, 20);		
		IntStream stream4 = IntStream.rangeClosed(1, 20); 
		System.out.println(stream3.parallel().findAny().getAsInt()); // farklı bir değer çıkarır.
		System.out.println(stream4.findAny().getAsInt()); // her zaman 1.
		
		IntStream stream5 = IntStream.rangeClosed(1, 20);
		IntStream stream6 = IntStream.rangeClosed(1, 20);
		System.out.println(stream5.parallel().skip(5).limit(2).findFirst().getAsInt()); // 6
		System.out.println(stream6.skip(5).limit(2).findFirst().getAsInt()); // 6
		
		IntStream stream7 = IntStream.rangeClosed(1, 20);
		IntStream stream8 = IntStream.rangeClosed(1, 20);
		System.out.println(stream7.parallel().unordered().skip(5).limit(2).findFirst().getAsInt()); 
							 // unordered metotu paralel streamlerde kullanışlıdır. Ve sonuç farklı çıkar.
		System.out.println(stream8.unordered().skip(5).limit(2).findFirst().getAsInt()); // 6
				
		System.out.println(Stream.of('w', 'o', 'l', 'f').parallel().reduce("", (a, b) -> a + b, 
				(a, b) -> a+ b));  // 3. parametre paralel streamler için geçerlidir.
		System.out.println(Stream.of('w', 'o', 'l', 'f').reduce("", (a, b) -> a + b, 
				(a, b) -> { throw new IllegalArgumentException(); })); // asla exception fırlatmaz.
		
		// paralel stream'ler reduce metotu ile 3. parametre olmadan toplama işlemi yaptığında doğru sonuç 
		// verir ancak çıkartma işlemi yaparsa yanlış sonuç verebilmektedir. Buna PROBLEMATIC ACCUMULATOR
																								  // denir.
		
		Set<Character> set = Stream.of('w', 'o', 'l', 'f').collect(TreeSet::new, 
				(x, y) -> x.add(y), (x, y) -> {System.out.println("paralel olmadıkça çalışmaz"); 
												x.addAll(y);});
		System.out.println(set);
		
		Set<Character> set2 = Stream.of('w', 'o', 'l', 'f').parallel().collect(TreeSet::new,
				(x,y) -> x.add(y), (x,y) -> x.addAll(y)); // burada 3. parametre de çalışır.
		System.out.println(set2);
	
	}
}
