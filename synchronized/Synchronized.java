public class Synchronized {
    public static void main(String[] args) throws InterruptedException {
	Thread thread1 = new Thread(()->{
	    try {
		for (int i = 0; i < 10; ++i) {
		    System.out.println("thread " + Thread.currentThread().getId() + " about to enter SynchronizedStaticMethods.f()");
		    SynchronizedStaticMethods.f();
		    System.out.println("thread " + Thread.currentThread().getId() + " has exited SynchronizedStaticMethods.f()");
		}
	    }
	    catch (InterruptedException e) {
	    }
	});
	
	Thread thread2 = new Thread(()->{
	    try {
		for (int i = 0; i < 10; ++i) {
		    System.out.println("thread " + Thread.currentThread().getId() + " about to enter SynchronizedStaticMethods.g()");
		    SynchronizedStaticMethods.g();
		    System.out.println("thread " + Thread.currentThread().getId() + " has exited SynchronizedStaticMethods.g()");
		}
	    }
	    catch (InterruptedException e) {
	    }

	});

	thread1.start();
	thread2.start();
	thread1.join();
	thread2.join();
    }
}

class SynchronizedStaticMethods {
    static synchronized void f() throws InterruptedException {
	// Class<> object is used as a lock
	System.out.println("thread " + Thread.currentThread().getId() + " has entered SynchronizedStaticMethods.f()");
	Thread.sleep(1000);
    }

    static synchronized void g() throws InterruptedException {
	System.out.println("thread " + Thread.currentThread().getId() + " has entered SynchronizedStaticMethods.g()");
	Thread.sleep(1000);
    }
}
