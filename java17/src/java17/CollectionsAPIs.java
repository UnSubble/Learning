package java17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsAPIs {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		
		System.out.println(list.add("Sparrow")); // true
		System.out.println(list.add("sparrow")); // true
		
		System.out.println(set.add("Sparrow")); // true
		System.out.println(set.add("Sparrow")); // false
		
		list.removeIf(x -> x.startsWith("S"));
		
		set.forEach(System.out::println);
		
		List<Integer> list1 = List.of(1, 2);
		List<Integer> list2 = List.of(2, 1);
		Set<Integer> set1 = Set.of(1,2);
		Set<Integer> set2 = Set.of(2,1);
		
		System.out.println(list1.equals(list2)); // false -> çünkü sıraya da bakıyor.
		System.out.println(set1.equals(set2)); // true

		String[] arr = {"a", "b", "c"};
		// Arrays.asList(arr); // -> eleman ekleyemeyiz, elemanları değiştirebiliriz, eleman silemeyiz.
		// arr[0] = "d"; // -> böyle değiştirebiliyoruz. List = {"d","b","c"}
		// list.set(1, "e"); // -> böyle de değişebiliyor. arr = {"d","e","c"}
		
		// List.of(arr); // -> eleman ekleyemeyiz, elemanları değiştiremeyiz, eleman silemeyiz.
		// List.copyOf(list1); // -> eleman ekleyemeyiz, elemanları değiştiremeyiz, eleman silemeyiz.
		
		var strings = new ArrayList<>(); // ArrayList<Object> olur.
		var strings2 = new ArrayList<String>(); // ArrayList<String> olur.
		
		var list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.remove(2); // {1,2} -> çünkü remove(int index)
		list3.remove(Integer.valueOf(2)); // {1} -> remove(T element)
		
		Object[] objArr = list3.toArray(); // object = {1}
		String[] strArr = list3.toArray(new String[0]); // string = {"1"} (verdiğimiz size önemsiz)
		
		list3.remove(0);
		System.out.println(Arrays.toString(strArr)); // ["1"] -> listeden sildiğimizde etkilenmiyor.
		
	}
}
