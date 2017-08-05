public class SynchronizedBlocks {
    public static void main(String[] args) throws InterruptedException {
	Thread thread1 = new Thread(new Activity());
	Thread thread2 = new Thread(new Activity());

	thread1.start();
	thread2.start();
	
	thread1.join();
	thread2.join();
    }

    private static Object lock = new Object();
    static void methodWithSynchronizedBlock() throws InterruptedException {
	System.out.println("Thread " + Thread.currentThread().getId() + " entered methodWithSyncronizedBlock()");
	// any instance of class Object can be used as synchronization lock
	synchronized(lock) {
	    System.out.println("Thread " + Thread.currentThread().getId() + " entered synchronized block");
	    Thread.sleep(10000);
	    System.out.println("Thread " + Thread.currentThread().getId() + " exited synchronized block");
	}
	System.out.println("Thread " + Thread.currentThread().getId() + " exited methodWithSyncronizedBlock()");
    }
}

class Activity implements Runnable {
    @Override
    public void run() {
	try {
	    for (int i = 0; i < 10; ++i) {
		SynchronizedBlocks.methodWithSynchronizedBlock();
	    }
	}
	catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
}
