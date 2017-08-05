public class SynchronizedInstanceMethods {
    public static void main(String[] args) throws InterruptedException {
	SynchronizedStorage storage = new SynchronizedStorage();

	Thread threadX = new Thread(new Producer(storage));
	Thread threadY = new Thread(new Consumer(storage));

	threadX.start();
	threadY.start();
	
	threadX.join();
	threadY.join();
    }
}

class Consumer implements Runnable {
    Consumer(SynchronizedStorage storage) {
	this.storage = storage;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 10; ++i) {
		System.out.println("Consumer about to get value");
		Integer value = null;
		while((value = storage.get()) == null); // this is naive, inefficient implementation
		System.out.println("Consumer got " + value);
	    }
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    private SynchronizedStorage storage;
}

class Producer implements Runnable {
    Producer(SynchronizedStorage storage) {
	this.storage = storage;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 10; ++i) {
		System.out.println("Producer about to put value " + i);
		while (!storage.put(i)); // again, this is naive, inefficient implementation
		Thread.sleep(500);
	    }
	}
	catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
    
    private SynchronizedStorage storage;
}

class SynchronizedStorage {
    // Class instance is used as a lock for all synchronized instance methods within the class,
    // so put() and get() could be entered by no more than one thread at the same time.
    synchronized Integer get() {
        Integer result = data;
        data = null;
        return result;
    }
    
    synchronized boolean put(Integer value) {
	if (data == null) {
	    data = value;
	    return true;
	}
	else {
	    return false;
	}
    }

    Integer data = null;
}
