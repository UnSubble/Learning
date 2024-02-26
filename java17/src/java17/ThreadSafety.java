package java17;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafety {
	private static int c = 0;
	private static volatile int d = 0;
	
	private static CyclicBarrier barrier = new CyclicBarrier(10);
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
			service.submit(() -> executeC());
		}
		for (int i = 0; i < 1000; i++) {
			service.submit(() -> executeD());
		}
		service.shutdown();
		System.out.println(c);
		System.out.println(d);
		
		// atomic işlemler -> atomic işlem ya olur ya da hiç olmaz. Yani araya başka bir iş girme ve kesinti
																							// durumu olmaz.
		// d++ işlemi atomic bir işlem değildir.
		// long ve double hariç tüm primitive ve referans tiplere yazma işlemi atomic'tir.
		// volatile olduğunda long ve double da dahil olmak üzere tüm primitive ve referans tiplere yazma 
																					// işlemi atomic'tir.
		// atomic işlemler hem okuma hem yazmayı aynı anda yapmayı garantiler. Fakat bu atomic eylemleri 
			// senkronize etme ihtiyacını ortadan kaldırmaz. Çünkü başka problemler ortaya çıkar. Memory tu-
			// tarlılığı problemleri gibi.
		// volatile değişkenler memory tutarlılığı problemini azaltır ancak bitirmez.
		// Memory tutarlılığı -> Farklı thread'ler aynı verinin ne olması gerektiği konusunda tutarsızlığa 
			// düştüğünde ortaya çıkar.
		// eğer atomic bir değişkeni thread-safe yapmak istiyorsak atmoic... class'ları kullanmalıyız.
		
		// AtomicInteger gibi class'ların metotları:
		// get() -> değeri getirir.
		// set(T newValue) -> verdiğimiz değeri yazar.
		// getAndSet(T newValue) -> eski değeri getirir ve verdiğimiz değeri yazar.
		// incrementAndGet() -> return ++value yapar.
		// getAndIncrement() -> return value++ yapar.
		// decrementAndGet() -> return --value yapar.
		// getAndDecrement() -> return value-- yapar.
		// addAndGet(T toAdd) -> toAdd + value yapar ve değeri döndürür. 
		
		ExecutorService service2 = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			final int atomicI = i + 1;
			service2.submit(() -> cleanCase(atomicI));
		}
		service2.shutdown();
		new CyclicBarrier(4, () -> System.out.println("done!")); // 4 thread'in de beklemeye geçtiği zaman
																// 2. parametre çalışır ve done! yazdırlır.
		// CyclicBarrier.await() metotunun bir overloaded versiyonu da süre parametresi alır. Bekleme işlemi
																// bu süreyi aştığında exception fırlatılır.
	}
	
	private static void increaseC() {
		c++;
	}
	
	private static void decreaseC() {
		c--;
	}
	
	private static synchronized void executeC() {
		increaseC();
		decreaseC();
	}
	
	private static void increaseD() {
		d++;
	}
	
	private static void decreaseD() {
		d--;
	}
	
	private static void executeD() {
		increaseD();
		decreaseD();
	}
	

	private static void cleanCase(int id) {
		System.out.println("cleaning case -> " + id);
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
		}
		closeCase(id);
	}
	
	private static void closeCase(int id) {
		System.out.println("closing case -> " + id);
	}
}
