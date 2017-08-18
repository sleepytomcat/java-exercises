import java.util.List;
import java.util.LinkedList;

public class SynchronizedWaitNotify {
    public static void main(String[] args) throws InterruptedException {
	DataQueue queue = new DataQueue(5);
	Thread producerThread = new Thread(new Producer(queue));
	Thread consumerThread = new Thread(new Consumer(queue));

	consumerThread.start();
	producerThread.start();

	consumerThread.join();
	producerThread.join();
    }
}

class Producer implements Runnable {
    Producer(DataQueue queue) {
	this.queue = queue;
    }

    @Override
    public void run() {
	while (true)
	    try {
		int value = nextValue++;
		System.out.println("producing value " + value);
		queue.put(value);
		System.out.println("value " + value + " produced");
	    }
	    catch (InterruptedException e) {
		e.printStackTrace();
		break;
	    }
    }

    DataQueue queue;
    int nextValue = 0;
}

class Consumer implements Runnable {
    Consumer(DataQueue queue) {this.queue = queue;}

    @Override
    public void run() {
	while (true)
	    try {
		Thread.sleep(1000);
		System.out.println("consuming value");
		int value = queue.get();
		System.out.println("value " + value + " consumed");
	    }
	    catch (InterruptedException e) {
		e.printStackTrace();
		break;
	    }
    }

    DataQueue queue;
}

class DataQueue {
    DataQueue(int bufferSize) {
	data = new LinkedList<Integer>();
	lock = new Object();
	this.bufferSize = bufferSize;
    }

    void put(int value) throws InterruptedException {
	synchronized(lock) {
	    while (data.size() >= bufferSize) { // because spurious wakeup is a possibility 
		// Current thread goes into waiting state,
		// allowing any other thread to enter this synchronized block.
		lock.wait();
	    }

	    data.add(value);
	    System.out.println("added " + value + ", now " + data);
	    lock.notify();
	}
    }

    int get() throws InterruptedException {
	synchronized(lock) {
	    while (data.size() == 0) // because spurious wakeup is a possibility
		lock.wait();

	    Integer value = data.remove(0);
	    System.out.println("removed " + value + ", now " + data);

	    // Waiting thread, if any, will be notified; however it will become active
	    // only after current thread would be leaving the synchronized block
	    // (which means there would be no more than one active thread here). 
	    lock.notify(); 
	    
	    return value;
	}
    }

    private List<Integer> data;
    Object lock; // actually, this could be used as a lock object
    int bufferSize;
}
