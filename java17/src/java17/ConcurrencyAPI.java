package java17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyAPI {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		try {
			System.out.println("begin");
			service.execute(() -> System.out.println(Thread.currentThread().getName()));
			service.execute(() -> System.out.println(Thread.currentThread().getName()));
			System.out.println("end");
		} finally {
			service.shutdown();
		}
		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		/*   ExecutorService
		 * 		Aktif iken                       Kapatılıyorken                 Kapandığında
		 * 			isShutdown() -> false			isShutdown() -> true			isShutdown() -> true
		 * 			isTerminated() -> false			isTerminated() -> false			isTerminated() -> true
		 */
		
		// aktif iken -> yeni görevleri alır, elindeki görevleri çalıştırır.
		// kapatılıyor iken -> yeni görev almaz, elindeki görevleri çalıştırır. Eğer yeni görev verilmeye
																		// çalışılırsa exception fırlatır.
		// kapatıldığında -> yeni görev almaz, elindeki görevleri çalıştırmaz. Zaten çalıştıracak görevi 
																						   // kalmamıştır.
		
		// elindeki görevlerin bitmesini beklemeden kapatmak istiyorsak shutdownNow() metotunu kullanırız.
		// Fakat bu metot da bitmeden kapanacağını garanti etmez.
		
		// execute() metotu void'dir. Fakat submit() metotu geriye Future<T> döner.
		// invokeAll() metotu da Collection<Callable<T>> alır ve geriye List<Future<T>> döner.
		// invokeAny() ise yine Collection<Callable<T>> alır ama geriye T tipinde döner.
		
	}
}
