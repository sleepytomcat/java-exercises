public class Finalizers {
    public static void main(String[] args) {
	System.out.println("Finalizers.main() started");
	Object obj = new MyClass();
	obj = null;
	// Un-commenting the next line increases the chances of MyObject.finalize() to be called
	// System.gc();
	System.out.println("Finalizers.main() finished");
    }
}

class MyClass {
    // While it looks like "destructor, Java-way", in fact it is not.
    // The purpose of finalize() is to support memory de-allocation when it was allocated in 
    // a way that Java cannot handle itself (i.e. within JNI call).
    //
    // The important part to remember: there's no guarantee finalize() would be ever called for any object. 
    @Override
    protected void finalize() throws Throwable {
	super.finalize();
        System.out.println("MyClass instance finalized");
    }
}
