import java.util.concurrent.ThreadFactory;

void main() throws Exception {
	Runnable runnable = () -> System.out.println(Thread.currentThread());;
	Thread thread1 = Thread.ofPlatform().daemon().start(runnable);
	Thread thread2 = Thread.ofPlatform().name("duke").unstarted(runnable);
	ThreadFactory factory1 = Thread.ofPlatform().daemon().name("worker-", 0).factory();
	Thread thread3 = Thread.ofVirtual().start(runnable);
	thread3.join();
	ThreadFactory factory2 = Thread.ofVirtual().factory();
}