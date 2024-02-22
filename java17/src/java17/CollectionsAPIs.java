package java17;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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
		
		Set<Integer> set3 = new HashSet<>();
		System.out.println(set3.add(10)); // true
		System.out.println(set3.add(20)); // true
		System.out.println(set3.add(null)); // true
		System.out.println(set3.add(10)); // false
		
		Set<StringBuilder> set4 = new HashSet<>();
		StringBuilder sb = new StringBuilder("me");
		StringBuilder sb2 = new StringBuilder("me");
		
		System.out.println(set4.add(sb)); // true
		System.out.println(set4.add(sb2)); // true çünkü StringBuilder equals() metotunu override etmemiştir.
		System.out.println(set4.remove(new StringBuilder("me"))); // false
		System.out.println(set4.remove(sb)); // true
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(10); // eğer queue doluysa false döndürür.
		queue.add(15); // eğer queue doluysa exception fırlatır.
		queue.remove(); // 10 // eğer queue boşsa exception fırlatır.
		queue.poll(); // 15 // eğer queue boşsa null döndürür.
		
		// metotların mantığı queue ile aynı
		Deque<Integer> deque = new ArrayDeque<>();
		deque.add(3); // [3]
		deque.addFirst(4); // [4,3]
		deque.addLast(5); // [4,3,5]
		deque.peek(); // 4
		deque.peekFirst(); // 4
		deque.peekLast(); // 5
		deque.poll(); // 4 
		deque.remove(); // 3
		deque.pollLast(); // 5
		deque.offerLast(6); // [6]
		deque.offer(4); // [4,6]
		
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.add(5);
		stack.peek(); // 5
		stack.pop(); // 5
	}
}
