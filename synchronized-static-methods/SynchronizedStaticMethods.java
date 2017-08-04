public class SynchronizedStaticMethods {
    public static void main(String[] args) throws InterruptedException {
	Thread threadX = new Thread(new ActivityX());
	Thread threadY = new Thread(new ActivityY());

	threadX.start();
	threadY.start();
	
	threadX.join();
	threadY.join();
    }

    // x() and y() are synchronized, so no more than one thread can enter synchronized section.
    // Note: x() and y() share same lock, so they are locked simultaneously;
    // i.e. when some thread enters x() - no other thread(s) can enter neither x() nor y() - until the lock is released.
    // Class<?> object is used as a lock for static methods.
    static synchronized void x() throws InterruptedException {
	System.out.println("thread " + Thread.currentThread().getId() + " has entered SynchronizedStaticMethods.x()");
	Thread.sleep(1000);
	System.out.println("thread " + Thread.currentThread().getId() + " has exited SynchronizedStaticMethods.x()");
    }

    static synchronized void y() throws InterruptedException {
	System.out.println("thread " + Thread.currentThread().getId() + " has entered SynchronizedStaticMethods.y()");
	Thread.sleep(1000);
	System.out.println("thread " + Thread.currentThread().getId() + " has exited SynchronizedStaticMethods.y()");
    }
}

class ActivityX implements Runnable {
    @Override
    public void run() {
	try {
	    for (int i = 0; i < 5; ++i) {
		System.out.println("thread " + Thread.currentThread().getId() + " about to enter SynchronizedStaticMethods.x()");
		SynchronizedStaticMethods.x();
	    }
	}
	catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}

class ActivityY implements Runnable {
    @Override
    public void run() {
	try {
	    for (int i = 0; i < 5; ++i) {
		System.out.println("thread " + Thread.currentThread().getId() + " about to enter SynchronizedStaticMethods.y()");
		SynchronizedStaticMethods.y();
	    }
	}
	catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
