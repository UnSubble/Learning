// predicate<T> T -> boolean
// consumer<T> T -> void
// supplier<T> void -> T
// function<T,V> T -> V

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateAndConsumerAndSupplierAndFunction {
	public static void main(String[] args) {
		Predicate<String> nullCheck = Objects::isNull;
		Predicate<String> lengthCheck = s -> s.length() > 4;
		Predicate<String> merged = nullCheck.and(lengthCheck);
		
		Supplier<String> sup = () -> "test";
		
	}
}
