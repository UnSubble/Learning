package java17;

public class Liveness {
	// 3 tip liveness problemi vardır -> 1-) Deadlock 2-) Starvation(açlık) 3-) Livelock(özel starvation 
																							  // durumudur.)
	
	public static void main(String[] args) {
		Liveness instance = new Liveness();
		instance.runDeadlock();
	}
	
	// DEADLOCK
	
	public void eatAndDrink(Object food, Object water) throws InterruptedException {
		synchronized(food) {
			System.out.println(Thread.currentThread().getName() + " got food!");
			move();
			synchronized(water) {
				System.out.println(Thread.currentThread().getName() + " got water!");
			}
		}
	}
	
	public void drinkAndEat(Object food, Object water) throws InterruptedException {
		synchronized(water) {
			System.out.println(Thread.currentThread().getName() + " got water!");
			move();
			synchronized(food) {
				System.out.println(Thread.currentThread().getName() + " got food!");			
			}
		}
	}
	
	public void move() throws InterruptedException {
		Thread.sleep(100);
	}
	
	public void runDeadlock() {
		Object food = new Object();
		Object water = new Object();
		new Thread(() -> {
			try {
				eatAndDrink(food, water);
			} catch (InterruptedException e) {
			}
		}).start();
		new Thread(() -> {
			try {
				drinkAndEat(food, water);
			} catch (InterruptedException e) {
			}
		}).start();
	}
	
	// END DEADLOCK
	
	// STARVATION
	
	// Thread'in kilidi almak için sürekli beklemesi gereken durumdur. Sıra diğer thread'lerden dolayı asla 
		// bu thread'e gelmez. Thread aktif durumdadır fakat hiçbir zaman kilide erişemez.
	
	// END STARVATION
	
	// LIVELOCK
	
	// 2 thread'in de 2 kilide ihtiyacı olduğu halde sürekli farklı kilidi aldığı ve diğer kilidi almak
		// elindekini  için bırakıp diğer kilidi alması bu durumda da yine elinde tek kilit kalması durumunda
		// gerçekleşir. Yani hem deadlock hem de starvation durumu söz konusudur.
	
	// END LIVELOCK
}
