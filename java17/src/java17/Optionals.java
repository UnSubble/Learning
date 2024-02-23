package java17;

import java.util.Optional;

public class Optionals {
	public static void main(String[] args) {
		Integer s = null;
		Optional<Integer> op = s == null ? Optional.empty():Optional.of(s); // bunun yerine alttakini kullan.
		Optional<Integer> opt = Optional.ofNullable(s);
		
		opt.isPresent(); // empty ise false değilse true
		
		opt.ifPresent(System.out::println); // empty değilse yazdırır.
		
		opt.orElse(s); // empty ise s değilse kendi değerini döner.
		
		opt.orElseGet(() -> 3);
		
		opt.orElseThrow(); // empty ise NoSuchElementException fırlatır değilse kendi değerini döner.
		
		opt.orElseThrow(IllegalStateException::new);
		
		opt.or(Optional::empty); // empty ise Optional.empty() döner değilse kendi değerini döner.
		
		// OptionalInt gibi primitive tipler için de türevleri vardır.
		
		Optional<Integer> threeDigit = Optional.of(100);
		threeDigit.map(String::valueOf).filter(x -> x.length() == 3).ifPresent(System.out::println);
		
	}
}
