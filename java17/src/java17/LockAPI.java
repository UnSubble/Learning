package java17;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPI {
	public static void main(String[] args) {
	// Lock interface metotları:
	// void lock() -> kilidi alır.
	// void unlock() -> kilidi bırakır.
	// boolean tryLock() -> diğer thread'lerin kilidi hemen bırakmasını sağlar. Eğer başarırsa true döner.
	// boolean tryLock(long timeout, TimeUnit unit) -> belirtilen süre boyunca veya kilidi alana kadar bekler
													// ve kilidi belirtilen süreden önce aldıysa true döner.
		
		// ReadWriteLock interface'i -> okuma işleminin yazma işlemine göre kat ve kat fazla olduğu
																				// durumlarda tercih edilir.
		// ReadWriteLock ile Lock interface'i arasında bir kalıtım yoktur. Sadece geriye Lock döner.
		// Lock readLock() -> aynı anda birden fazla thread tarafından tutulabilen bir kilit döndürür.
		// Lock writeLock() -> yalnızca bir thread tarafından tutulan bir kilit döndürür.
		// ReentrantReadWriteLock class'ı bu interface'i implemente etmektedir.
		
	}
	
	private void usage() {
		Lock lock = new ReentrantLock();
		try {
			lock.lock();
		} finally {
			lock.unlock(); // eğer sahip olmadığımız kilidi açmaya çalışırsak IllegalMonitorStateException
		}																					// fırlatır.
	}
	
	private void usage2() {
		Lock lock = new ReentrantLock();
		if (lock.tryLock()) {
			try {
				// ....
			} finally {
				lock.unlock(); 
			}
		}
	}
}
