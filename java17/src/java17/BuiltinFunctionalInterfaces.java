package java17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public class BuiltinFunctionalInterfaces {
	
	public static void main(String[] args) {
		Supplier<String> supp = String::new;	
		Supplier<List<String>> listSupp = ArrayList::new;
		
		// Supplier<String> sup = String::isEmpty; // DOES NOT COMPILE çünkü isEmpty metotu statik değil.
		
		Consumer<String> con = System.out::println;
		
		// Consumer<String> ccc = x -> "str"; // DOES NOT COMPILE çünkü consumer'ın metotu void
		
		Consumer<String> cons = BuiltinFunctionalInterfaces::voidmethod; // normalde geriye bir şey dönmemesi
																		// lazım ama metotlarda istisna var.
		
		BiConsumer<String, String> bc1 = String::concat; // geriye döndüğü değeri alamıyoruz.		
		Map<String, String> map = new HashMap<>();
		BiConsumer<String, String> bc2 = map::put;		
		BiConsumer<List<String>, String> bc3 = List::add;
		
		Predicate<List<String>> pre = List::isEmpty;
		
		BiPredicate<List<String>, String> pre2 = List::contains;		
		BiPredicate<String, String> pre3 = String::startsWith;
		
		Function<String, Integer> func = String::length;
		
		Function<Integer, Integer> func2 = x -> x * 3;
		
		BiFunction<Integer, Integer, Integer> bifunc = Integer::sum;
		
		UnaryOperator<Integer> op = x -> x * 5;		
		UnaryOperator<String> op2 = String::toUpperCase;
		
		BinaryOperator<String> bop = String::concat;		
		BinaryOperator<Double> bop2 = Math::pow;
		
		Predicate<Integer> pre4 = x -> true;
		Predicate<Integer> pre5 = x -> false;		
		Predicate<Integer> pre6 = pre4.and(pre5.negate());
		
		Function<Integer, Integer> before = x -> x + 1;
		Function<Integer, Integer> after = x -> x * 2;		
		Function<Integer, Integer> combined = after.compose(before); // ilk before sonra after çalışır.
		Function<Integer, Integer> andThen = before.andThen(after); // ilk before sonra after çalışır.
		
		BooleanSupplier sup2 = () -> true;  // boolean primitive metotu bir tek supplier'da var.
		IntSupplier sup3 = () -> 3;
		DoubleSupplier sup4 = () -> 3.1459;
		LongSupplier sup5 = () -> 999999L;
		
		ToDoubleFunction<Integer> dfunc = x -> x * 2.5;
		ToDoubleFunction<String> dfunc2 = Double::parseDouble;		
		ToIntFunction<String> ifunc = Integer::parseInt;		
		ToLongFunction<Integer> lfunc = i -> i * 123L;
		
		ToDoubleBiFunction<Integer, Integer> dbfunc = Double::sum;
		
		DoubleToLongFunction idfunc = Math::round;
		
		ObjDoubleConsumer<Integer> odcon = (x,y) -> System.out.println(x + y);
		ObjIntConsumer<Long> oicon = (x,y) -> System.out.println(x + y);
		ObjLongConsumer<Long> olcon = (x, y) -> System.out.println(Math.max(x, y));
	}	
	
	static boolean voidmethod(String str) {
		System.out.println(str);
		return true;
	}
}
