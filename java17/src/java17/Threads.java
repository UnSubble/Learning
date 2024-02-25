package java17;

import java.util.Set;

public class Threads {
	public static void main(String[] args) {
		new Thread(() -> System.out.println("Hello")).start();
		System.out.println("World");
		// çıktı: HelloWorld veya WorldHello
		System.out.println();
		System.out.println(Thread.currentThread().getName()); // main
		new Thread(() -> System.out.println("hello")).run(); // run yeni bir thread başlatmaz.
		new MyThread().start(); // kendi thread'imizi oluşturmak için run metotunu override edebiliriz.
		
		// bir thread sadece bir kez start edilebilir. Tıpkı stream gibi. Bir daha start etmek denenirse
		// exception fırlatır.
		
		// Thread'in bir constructor'ı da (Runnable runnable, String name) alandır. Name = Thread'in ismi
		
		// Daemon thread'ler JVM ve kullanıcı tarafından oluşturulabilir. Progarm tamamlandığında bu thread 
		// görevini bitirmeden uygulamayı bitirir.
		Thread thread = new Thread(() -> {
			System.out.println("Deamon sample");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			System.out.println("this line is never prints");
		});
		thread.setDaemon(true); // bu satırı thread'i başlattıktan sonra yazarsak exception fırlatır.
		thread.start();
		
		Thread mainThread = Thread.currentThread();
		
		Thread thread1 = new Thread();
		
		System.out.println(thread1.getState()); // NEW
		System.out.println(thread1.isAlive()); // false
		
		thread1.start();
		
		System.out.println(thread1.getState()); // RUNNABLE
		System.out.println(thread1.isAlive()); // true
		
		Set<Thread> threads = Thread.getAllStackTraces().keySet();
		for (Thread t : threads) {
			System.out.printf("%-20s    %-20s    %-20s    %s\n", t.getName(), t.getState(),
					t.getPriority(), t.isDaemon());
		}
		
		// Thread.sleep(long millis); veya Thread.sleep(long millis, int nanos);
		
		// interrupt metotu sadece time-waiting veya waiting state'lerindeyken thread'i uyandırır ve 
		// InterruptedException fırlatmasını sağlar. (wait halleri Thread.sleep() ve Object.wait() metotları)
	}	
}

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("overrided");
	}
	
}