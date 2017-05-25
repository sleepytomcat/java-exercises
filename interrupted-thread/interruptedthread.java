class InterruptedThread {
    public static void main(String[] args){
	MyThread t = new MyThread();
	t.start();
	try {
	    Thread.sleep(5000);
	}
	catch (InterruptedException e) {
	    System.out.println("main interrupted");
	}

	t.interrupt(); // interrupting other thread here

	try {
	    t.join();
	}
	catch (InterruptedException e) {
	    System.out.println("main interrupted");
	}
    }
}

class MyThread extends Thread {
    public void run() {
	try {
	    while (true) {
		System.out.println("thread running");
		sleep(1000);
	    }
	}
	catch (InterruptedException e) {
	    System.out.println("thread interrupted");
	}
    }
}
