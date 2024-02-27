package java17;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollection {
	// class                   interface          		sorted?          blocking?
	// ConcurrentHashMap   	   Map				  		No			     No
							// ConcurrentMap
	
	// ConcurrentLinkedQueue   Queue              		No               No
	
	// ConcurrentSkipListMap   Map						Yes				 No
						    // SortedMap
							// NavigableMap
							// ConcurrentMap
							// ConcurrentNavigableMap
	
	// ConcurrentSkipListSet   Set						Yes				 No
							// SortedSet
							// NavigableSet
	
	// CopyOnWriteArrayList    List                     No               No
	
	// CopyOnWriteArraySet     Set                      No               No
	
	// LinkedBlockingQueue     Queue					No               Yes
							// BlockingQueue
	
	public static void main(String[] args) {
		List<Integer> favNums = new CopyOnWriteArrayList<Integer>(List.of(4, 3, 42));
		for (int n : favNums) {
			System.out.print(n + " "); // 4 3 42
			favNums.add(n + 1);  // normal bir list olsaydı ConcurrentModificationException fırlatırdı.
		}
		System.out.println();
		System.out.println(favNums.size()); // 6
		
		// CopyOnWrite class'lar çok memeory kullanır. Çünkü her ekleme/çıkartma işleminde yeni bir collec-
			// tion oluşturulur.
		
		// Collections sınıfı concurrent için uygun olmayan class'ları senkron hale getirmek için 
			// Colloctions.synchronizedList(List<T> list) gibi metotlar içerir.
		// bu synchronized class'lar concurrent class'lara göre daha yavaş çalışır.
		
		
	}
}
