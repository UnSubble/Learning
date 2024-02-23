package java17;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class UsingSpliterator {
	public static void main(String[] args) {
		// trySplit() metotu elimizde buluna spliterator'ı yarısından ikiye bölerek döndürür.
		
		// forEachRemaining(Consumer) kalan data'yı iterate'ler.
		
		// tryAdvance(Consumer) içerisinde tek bir eleman varsa onu işler.
		
		Spliterator<String> sp = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-")
				.spliterator(); 
		Spliterator<String> spHalf = sp.trySplit(); 
		spHalf.forEachRemaining(System.out::print); // bird-bunny-cat-
		
		System.out.println();
		// sp = ["dog-", "fish-", "lamb-", "mouse-"]
		Spliterator<String> othHalf = sp.trySplit();  // othHalf = ["dog-", "fish-"]
		othHalf.tryAdvance(System.out::print); // dog- 

		System.out.println();
		// sp = ["fish-"]	
		othHalf.forEachRemaining(System.out::print); // fish-
		
		System.out.println();
		sp.forEachRemaining(System.out::print);
		
		System.out.println();
		
		Spliterator<Integer> intSp = List.of(1,2,3,4,5,6,7,8,9).spliterator();
		System.out.println(intSp.estimateSize());
		System.out.println(intSp.getExactSizeIfKnown());
		
		Stream<Integer> inf = Stream.generate(() -> 1);
		Spliterator<Integer> infSp = inf.spliterator();
		System.out.println(infSp.estimateSize());
		System.out.println(infSp.getExactSizeIfKnown());
	}
}
