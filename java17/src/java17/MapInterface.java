package java17;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class MapInterface {
	public static void main(String[] args) {
		Map<Integer, Integer> map = Map.of(2, 3); // immutable
		Map.ofEntries(Map.entry("a", 5), Map.entry("b", 6)); // immutable
		
		// map.put(4, 6); // throws Exception
		// map.remove(6); // throws Exception
		// map.replace(2, 3); // throws Exception
		
		// HashTable -> synchronized'dır.
		
		map.getOrDefault(6, null);
		
		map.put(4, 8);
		map.replace(2, 7); // {2=7, 4=8}
		map.replace(3, 7); // {2=7, 4=8}
		
		Integer val = map.putIfAbsent(5, 9); // değer varsa eklemez ve değerini döndürür. Yoksa ekler ve 
											 // yeni değeri döndürür. Değer null ise sanki yokmuş gibi 
											 // davranır. 
		
		map.putIfAbsent(123, null); // null olsa da ekler.
		
		map.merge(4, 10, (x, y) -> x > y ? x : y); // değer yoksa 10 koyar. Varsa eski değer ile yeni değeri 
												  // karşılaştırır. Hangisi büyükse onu koyar. Sonra da 
												  // key'e karşılık gelen value değerini döndürür. 
												  // NOT: eğer key-value çifti yoksa veya null'sa function 
												  // çağrılmaz. Direkt verdiğimiz değeri value olarak koyar.
		
		map.merge(4, 15, (x, y) -> null); // eğer key-value çifti varsa null yaptığı için silinir. Eğer 
										  // key-value çifti yoksa key'e karşılık 15 değerini koyar.
		
		map.put(null, null); // {null=null} olarak ekler.
		map.put(null, 5); // {null=5} olarak ekler.
		map.put(5, null); // {5=null} olarak ekler.
		
		Map<String, String> hashtable = new Hashtable<>();
		// hashtable.put(null, "s"); // throws Exception -> key null kabul etmez.
		// hashtable.put("s", null); // throws Exception -> value null kabul etmez.
		
		Map<String, String> treemap = new TreeMap<>();
		// treemap.put(null,  "s"); // throws Exception -> key null kabul etmez.
		// treemap.put("s",  null); // value null kabul eder.
	}
}
