package java17;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConcurrencyAPI {
	private static int counter = 0;
	
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
		
		
		// Future interface metotları:
		// boolean isDone() -> eğer görevi tamamlanmışsa veya iptal edilmişse true döner. 
		// boolean isCancelled() -> eğer görev normal şekilde tamamlanmadıysa true döner. (Exception dahil
																								// değil)
		// boolean cancel(boolean mayInterruptIfRunning) -> Görevi iptal etmeye çalışır, ederse true döner.
		// V get() -> görevin sonucunu almak için bitene kadar bekler.
		// V get(long timeout, TimeUnit unit) -> belirtilen süre kadar bekler ve hala değer dönmediyse 
																			// TimeoutException fırlatır. 
		
		
		ExecutorService service1 = Executors.newSingleThreadExecutor();
		Future<?> future = service1.submit(() -> { // geriye dönen değer olmadığı zaman runnable overloaded
			for (int i = 0; i < 10000000; i++) {	// runnable metotu çağrılır. Ve geriye null döner.
				counter++;
			}
		});
		try {
			System.out.println(future.get(30, TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			service1.shutdown();
		}
		try {
			service1.awaitTermination(1, TimeUnit.MINUTES); // tüm görevleri tamamlamak için beklenmesi 
		} catch (InterruptedException e) {					// gereken süreyi belirtir. Eğer görevler tamam-
			Thread.currentThread().interrupt();				// lanmışsa veya InterruptedException fırlatıl- 
		}													// mışsa bekleme sonlanır.
		System.out.println("done");
		
		
		// ScheduledExecutorService interface metotları:
		// bütün scheduledExecutorService metotları ScheduledFuture<T> döner.
		// schedule(Callable<T> callable, long delay, TimeUnit unit) -> verilen süreden sonra verilen görevi
																								// yapar.
		// schedule(Runnable command, long delay, TimeUnit unit) -> verilen süreden sonra verilen görevi 
																								// yapar.
		// scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) -> verilen 
			// süreden sonra verilen görevi yapar ardından periyoda girer. 5s 10s 15s 20s... gibi çalışır.
			// aradaki görev süresi önemsenmez.
		// scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) -> verilen
			// süreden sonra verilen görevi yapar ardından periyoda girer. 5s+x 10s+x 15s+x... gibi çalışır.
			// (x görevin yapılma süresi). Yani görev süresi önemsenir.
		
		
		ScheduledExecutorService scheduled = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Hello zoo");
		Callable<String> task2 = () -> "monkey";
		ScheduledFuture<?> r1 = scheduled.schedule(task1, 100L, TimeUnit.MILLISECONDS);
		ScheduledFuture<?> r2 = scheduled.schedule(task2, 80L, TimeUnit.MILLISECONDS);
		scheduled.shutdown();
		try {
			System.out.println(r1.get()); // null
			System.out.println(r2.get()); // monkey
		} catch (InterruptedException | ExecutionException e) {
		}
		
		// Executors.newCachedThreadPool() -> thread sayısını kendi belirler. boşa çıkan thread'e yeni 
			// görev atar. thread belli bir süre kullanılmazsa kapatılır.
		// Executors.newFixedThreadPool(int nThreads) -> belirli bir sayıda thread alır. boşa çıkan threa'e
			// yeni görev atar.
		// Executors.newScheduledThreadPool(int corePoolSize) -> belirli bir sayıda thread alır ve single
		    // scheduled thread ile aynı görevi yapar.
		ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		executor2.shutdown();
	}
}
