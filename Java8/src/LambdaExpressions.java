// Functional interfaceler sadece ve sadece 1 tane abstract method bulundurabilir.
// public abstract yazmamıza gerek yok, interface'te oto öyle geliyor zaten.

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;

@FunctionalInterface
interface Converter<T> {
	public abstract T convert(String val);
}

// Legaldir.
@FunctionalInterface
interface Sub<T> extends Converter<T> {
	@Override
	T convert(String val);
}


public class LambdaExpressions {
	public static void main(String[] args) {
		Converter<Integer> converter = x -> x.length();
		
	}
}
