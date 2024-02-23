package java17;

import java.util.Optional;

public class Optionals {
	public static void main(String[] args) {
		Integer s = null;
		Optional<Integer> op = s == null ? Optional.empty():Optional.of(s); // bunun yerine alttakini kullan.
		Optional<Integer> opt = Optional.ofNullable(s);
		
		opt.isPresent(); // empty ise false değilse true
		
		opt.orElse(s); // empty ise s değilse kendi değerini döner.
		
		opt.orElseGet(() -> 3);
		
		opt.orElseThrow(); // empty ise NoSuchElementException fırlatır değilse kendi değerini döner.
		
		opt.orElseThrow(IllegalStateException::new);
		
		opt.or(Optional::empty); // empty ise Optional.empty() döner değilse kendi değerini döner.
	}
}
