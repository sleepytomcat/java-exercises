class Threads {
    static public void main(String[] args) {
	ExtendingThread threadA = new ExtendingThread();
	ImplementingRunnable threadB = new ImplementingRunnable();

	threadA.start();
	threadB.start();

	try {
	    threadA.join();
	    threadB.join();
	}
	catch (InterruptedException e) {
	    System.out.println("main() interrupted");
	}

	System.out.println("Threads finished");
    }
}

class ExtendingThread extends Thread {
    public void run() {
	for (int i = 15; i > 0; --i) {
	    System.out.println("ExtendingThread thread is running " + i);
	    try {
	        Thread.sleep(1000); // 1000 ms
	    }
	    catch(InterruptedException e) {
		System.out.println("ExtendingThread thread interrupted");
	    }
	}
    }
}

class ImplementingRunnable implements Runnable {
    private Thread t;
    ImplementingRunnable() {
	t = new Thread(this);
    }

    void join() throws InterruptedException {
	t.join();
    }

    void start() {
	t.start();
    }

    public void run() {
	for (int i = 10; i > 0; --i) {
	    System.out.println("ImplementingRunnable thread is running " + i);
	    try {
		Thread.sleep(1000); // 1000 ms
	    }
	    catch(InterruptedException e) {
		System.out.println("ImplementingRunnable thread interrupted");
	    }
	} 
    }
}
