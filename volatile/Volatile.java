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
	    int local_value = MY_INT;
	    while (local_value < 5) {
		if (local_value != MY_INT) {
		    System.out.println("Got Change for MY_INT :" + MY_INT);
		    local_value = MY_INT;
		}

		// Adding the Thread.sleep(500) would likely 'fix' the issue even if there's no 'volatile' modifier
		// applied to MY_INT - the reason for this JVM would decide it's Ok to propagate shared memory changes to 
		// local thread memory.
		// try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
	    }
	}
    }

    static class ChangeMaker extends Thread{
	@Override
	public void run() {
	    int local_value = MY_INT;
	    while (local_value < 5) {
		System.out.println("Incrementing MY_INT to " + (local_value + 1));
		MY_INT = ++local_value;
		try {
		    Thread.sleep(500);
		} 
		catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}
