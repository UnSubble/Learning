package java17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNums = Stream.iterate(1, i -> i + 2);
		Stream<Integer> evens = Stream.of(2,4,6,8);
		Stream<String> empty = Stream.empty();
		
		Stream<Integer> evens2 = Stream.iterate(2, i -> i < 2, i -> i + 2);
		Stream<Integer> evens3 = Stream.iterate(2, i -> i < 3, i -> i + 2);
		
		evens2.forEach(System.out::println); // nothing...
		evens3.forEach(System.out::println); // 2
		
		String[] values = {"value1", "value2", "value3"};
		Arrays.stream(values).forEach(System.out::println); // "value1", "value2", "value3"
		Stream.of(values).forEach(System.out::println); // "value1", "value2", "value3"
		
		Stream<Integer> numbers = Stream.<Integer>builder().add(1).add(2).add(3).build();
		numbers.forEach(System.out::println);
		
		Stream<String> letters = Pattern.compile("\\s").splitAsStream("a b c");
		letters.forEach(System.out::println);
		
		Stream<String> maxes = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(maxes.max((x,y) -> x.length() - y.length()).get());
		
		Stream<String> mins = Stream.of("maa", "aaaaaaa", "aaabbbc", "a"); // aaaaaaa
		System.out.println(mins.min(Comparator.comparingInt(String::length)).get()); // a
		
		Stream<String> findAny = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(findAny.findAny().get()); // maa (paralel streamlerde farklı sonuçlar verebilir.)
		
		Stream<String> findFirst = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(findFirst.findFirst().get()); // maa
		
		Stream<String> allMatch = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(allMatch.allMatch(x -> x.startsWith("a"))); // false
		
		Stream<String> anyMatch = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(anyMatch.anyMatch(x -> x.startsWith("m"))); // true
		
		Stream<String> noneMatch = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		System.out.println(noneMatch.noneMatch(x -> false)); // true
		
		// Sonsuz streamleri:
		// findAny() -> sonlandırır.
		// findFirst() -> sonlandırır.
		// allMatch() -> bazen sonlandırır.
		// anyMatch() -> bazen sonlandırır.
		// noneMatch() -> bazen sonlandırır.
		// forEach() -> sonlandırmaz.
		// count() -> sonlandırmaz.
		// min() -> sonlandırmaz.
		// max() -> sonlandırmaz.
		// reduce() -> sonlandırmaz.
		
		Stream<String> concat = Stream.of("w", "o", "l", "f");
		System.out.println(concat.reduce("---", (x,y) -> x + y)); // ---wolf
		
		Stream<Integer> addingInt = Stream.of(3, 5, 7, 9);
		System.out.println(addingInt.reduce(2, (x,y) -> x * y)); // 1890
		
		Stream<String> concatOpt = Stream.of("w", "o", "l", "f");
		System.out.println(concatOpt.reduce((x,y) -> x + y)); // Optional[wolf]
		
		Stream<String> reduce = Stream.of("w", "o", "l", "f!");
		System.out.println(reduce.reduce(0, (i,s) -> i + s.length(), (a,b) -> a + b)); // 5
		// 3 argümanlı reduce metotu paralel streamler için kullanışlıdır.
		// 3. argüman olan combiner intermediate total'leri combine eder. (Yani burada toplar.)
		// Ayrıca farklı tipler kullanırken bu overloaded versiyonu kullanırız.
		
		Stream<String> collecting = Stream.of("w", "o", "l", "f");
		StringBuilder word = collecting.collect(StringBuilder::new, 
				StringBuilder::append, StringBuilder::append); // wolf
		// yine 3. argüman paralel streamler içindir.
		
		Stream<String> collectingList = Stream.of("w", "o", "l", "f");
		System.out.println(collectingList.collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
																						// [w, o, l, f]
		
		Stream<String> filtering = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		filtering.filter(x -> x.startsWith("m")).forEach(System.out::println); // maa
		
		Stream<String> distinct = Stream.of("aa", "aa", "aa", "a");
		distinct.distinct().forEach(System.out::println); // aa, a
		
		Stream<Integer> odds = Stream.iterate(1, i -> i + 2);
		odds.limit(6).forEach(System.out::println); // 1 3 5 7 9 11
		
		Stream<Integer> odds2 = Stream.iterate(1, i -> i + 2);
		odds2.skip(4).limit(3).forEach(System.out::println); // 9 11 13 15
		
		Stream<Integer> evenTest = Stream.iterate(2, i -> i + 1);
		evenTest.filter(i -> i % 2 == 0)
				.skip(2)
				.limit(5)
				.forEach(System.out::println); // 6 8 10 12 14
		
		Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14)
				.filter(i -> i % 2 == 0)
				.limit(5)
				.skip(2)
				.forEach(System.out::println); // 6 8 10
		
		Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14)
				.limit(5)
				.filter(i -> i % 2 == 0)
				.skip(2)
				.forEach(System.out::println); // nothing...
		
		Stream<String> map = Stream.of("maa", "aaaaaaa", "aaabbbc", "a");
		map.map(String::length).forEach(System.out::println); // 3 7 7 1
		
		Stream<Stream<String>> flatMap = Stream.of(Stream.of("maa", "aaaaaaa"), Stream.of("aaabbbc", "a"));
		flatMap.flatMap(x -> x).forEach(System.out::println); // maa aaaaaaa aaabbbc a
		
		Stream<List<String>> flatMap2 = Stream.of(List.of("maa", "aaaaaaa"), List.of("aaabbbc", "a"));
		flatMap2.flatMap(x -> x.stream()).forEach(System.out::println); // maa aaaaaaa aaabbbc a

		System.out.println(Stream.of("black bear", "brown bear" , "grizzly")
				.filter(p -> p.length() > 4) // filter metotu peek'in çalışması için gereklidir.
				.peek(System.out::println).count()); // peek intermediate bir metottur. Bu yüzden terminal
													 // metot almadan çalışmaz.
		
		Stream.of("black bear", "brown bear" , "grizzly").sorted(Comparator.reverseOrder())
				.forEach(System.out::println);
		
		Stream<Integer> streamInteger = Stream.of(1,2,3,4,5);
		IntStream streamInt = streamInteger.mapToInt(x -> x);
		System.out.println(streamInt.average()); // OptionalDouble[3.0]
		
		Stream<Double> streamDouble = Stream.of(1.0,2.0,3.0,4.0,5.0);
		DoubleStream streamPrimitiveDouble = streamDouble.mapToDouble(x -> x);
		Stream<Double> boxed = streamPrimitiveDouble.boxed();
		
		IntStream.range(1, 6).forEach(System.out::println); // 1 2 3 4 5
		
		LongStream.rangeClosed(1, 5).forEach(System.out::println); // 1 2 3 4 5
		
		System.out.println(IntStream.rangeClosed(1, 5).sum()); // 15
		
		System.out.println(IntStream.rangeClosed(1, 5).summaryStatistics());
								// IntSummaryStatistics{count=5, sum=15, min=1, average=3,000000, max=5}
		
		System.out.println(IntStream.rangeClosed(1, 5).summaryStatistics().getMax()); // 5
		
		Stream<Double> streamDouble2 = Stream.of(1.0,2.0,3.0,4.0,5.0);
		DoubleStream streamPrimitiveDouble2 = streamDouble2.mapToDouble(x -> x);
		Stream<Double> boxedObj = streamPrimitiveDouble2.mapToObj(x -> x);
		
		List<String> cats = new ArrayList<>();
		cats.add("Annie");
		cats.add("Ripley");
		Stream<String> str = cats.stream();
		cats.add("KC");
		System.out.println(str.count()); // 3 // Stream'lerin çalışması için terminal operation gerekli.
											  // yani count metotu çağırılınca stream oluşur.
		
		Stream<String> oh = Stream.of("lions", "tigers", "bears");
		System.out.println(oh.collect(Collectors.joining())); // lionstigersbears
		
		Stream<String> oh2 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh2.collect(Collectors.joining("-"))); // lions-tigers-bears
		
		Stream<String> oh3 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh3.collect(Collectors.joining(", ", "(", ")"))); // (lions, tigers, bears)
		
		// Primitive streamlerde collectors'ün olduğu overloaded collect() metotu yoktur.
		
		Stream<Integer> no = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no.collect(Collectors.averagingInt(x -> x))); // 5.0
		
		Stream<String> oh4 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh4.collect(Collectors.toCollection(TreeSet::new)));
		//Collectors.toUnmodifiableList();
		//Collectors.toSet();
		//Collectors.toList();
		
		Stream<Integer> no2 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no2.collect(Collectors.counting())); // 9
		
		Stream<Integer> no3 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no3.collect(Collectors.filtering(x -> x > 5, Collectors.toList())));
		
		Stream<Integer> no4 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no4.collect(Collectors.maxBy(Comparator.naturalOrder()))); // Optional[9]
		
		Stream<Integer> no5 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no5.collect(Collectors.summarizingInt(x -> x)));
								   // IntSummaryStatistics{count=9, sum=45, min=1, average=5,000000, max=9}
		
		Stream<Integer> no6 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no6.collect(Collectors.summingInt(x -> x))); // 45
		
		Stream<String> oh5 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh5.collect(Collectors.toMap(x -> x, x -> x.length()))); 
																			// {lions=5, bears=5, tigers=6}
		
		Stream<String> oh6 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh6.collect(Collectors.toMap(Function.identity(), String::length))); 
																			// {lions=5, bears=5, tigers=6}
		// eğer Collectors.toMap() metotunda aynı key gelirse exception fırlatır.
		
		Stream<String> oh7 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh7.collect(Collectors.toMap(String::length, Function.identity(),
				(a, b) -> a + "," + b))); //	{5=lions,bears, 6=tigers}	
		
		Stream<String> oh8 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh8.collect(Collectors.toMap(String::length, Function.identity(),
				(a, b) -> a + "," + b, LinkedHashMap::new))); //	{5=lions,bears, 6=tigers}			
		
		Stream<String> oh9 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh9.collect(Collectors.groupingBy(String::length)));
		
		Stream<String> oh10 = Stream.of("lions", "tigers", "bears", "bears", "lions", "tigers", "bears");
		System.out.println(oh10.collect(Collectors.groupingBy(String::length, Collectors.toSet())));
		
		Stream<String> oh11 = Stream.of("lions", "tigers", "bears", "bears", "lions", "tigers", "bears");
		System.out.println(oh11.collect(Collectors.groupingBy(String::length, TreeMap::new,
				Collectors.toList())));
		
		Stream<String> oh12 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh12.collect(Collectors.partitioningBy(x -> x.length() < 7)));
						// {false=[], true=[lions, tigers, bears]}
						// partitoningBy() metotu true ve false'a göre ayırır.
		
		Stream<String> oh13 = Stream.of("lions", "tigers", "bears", "bears", "lions", "tigers", "bears");
		System.out.println(oh13.collect(Collectors.partitioningBy(x -> x.length() < 7, 
				Collectors.toSet())));
		
		Stream<String> sample = Stream.of("lions", "tigers", "bears", "bears", "lions", "tigers", "bears");
		System.out.println(sample.collect(Collectors.groupingBy(String::length, Collectors.counting())));
		
		Stream<String> oh14 = Stream.of("lions", "tigers", "bears");
		System.out.println(oh14.collect(Collectors.mapping(String::length, Collectors.toSet())));
		
		Stream<String> sample2 = Stream.of("lions", "tigers", "bears", "bears", "lions", "tigers", "bears");
		System.out.println(sample2.collect(Collectors.groupingBy(String::length, 
				Collectors.mapping(x -> x.charAt(0), Collectors.minBy((x,y) -> x - y)))));
					// bu yapı ilk önce kelimeleri uzunluğuna göre ayırıyor. Daha sonra ilk karakterlerine
					// mapliyor. Daha sonra da ilk karakterlerinden en küçük olanları alıyor ve Map<Integer,
					// Optional<Character>> şeklinde dönüyor.
		
		
		record Separations(String spaceSeperated, String commaSeparated) {
		}
		
		List<String> charList = List.of("x", "y", "z");
		Separations result = charList.stream()
				.collect(Collectors.teeing(Collectors.joining(" "), 
				Collectors.joining(","), (s,c) -> new Separations(s,c)));
		System.out.println(result);
		
		Stream<Integer> no7 = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println(no7.collect(Collectors.teeing(Collectors.summingDouble(x -> x), 
				Collectors.counting(), (x, y) -> x / y))); // ortalama bulmak için -> 5.0
	}
	
	public static List<String> get() throws IOException {
		return new ArrayList<>();
	}
	
	public void bad() throws IOException {
		// Supplier<List<String>> supp = Streams::get; // DOES NOT COMPILE çünkü supplier checked exception
															// handle edemez.
		Supplier<List<String>> sup = () -> {
			try {
				return get();
			} catch (IOException e) {
				throw new RuntimeException();
			}
		};
	}
	
	public void good() throws IOException {
		get().stream().count();
	}
}
