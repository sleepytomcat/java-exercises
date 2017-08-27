public class Volatile {
    // According to documentation, 'volatile' ensures that variable access would be atomic;
    // also, it ensures the value would not be cached in thread memory,
    // but will be properly updated from main memory every time.
    //
    // In this example ChangeListener runs a loop heavily, so the chances are high JVM (in absence of 'volatile')
    // would decide to cache MY_INT value in thread's local memory, which would effectively mean
    // ChangeListener and ChangeMaker are writing into two different variables (however, it's not so clear from the code).
    //
    // Other solution to the problem could be synchronised access to data, as synchronizaton also creates 'happens-before'
    // relation in Java memory model.
    private static /* volatile */ int MY_INT = 0;
    public static void main(String[] args) {
	new ChangeListener().start();
	new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
	@Override
	public void run() {
	    int last_known_value = MY_INT;
	    while (last_known_value < 5) {
		if (last_known_value != MY_INT) {
		    System.out.println("Thread A: MY_INT changed, was " + last_known_value + " now " + MY_INT);
		    last_known_value = MY_INT;
		}

		// Adding the Thread.sleep(5) would likely 'fix' the issue even if there's no 'volatile' modifier
		// applied to MY_INT - the reason for this JVM would decide it's Ok to propagate shared memory changes to 
		// local thread memory.
		// try {Thread.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
	    }
	}
    }

    static class ChangeMaker extends Thread{
	@Override
	public void run() {
	    while (MY_INT < 5) {
		try {
		    Thread.sleep(500);
		} 
		catch (InterruptedException e) {
		    e.printStackTrace();
		}

		++MY_INT;
		System.out.println("Thread B: incrementing MY_INT to " + MY_INT);
	    }
	}
    }
}
