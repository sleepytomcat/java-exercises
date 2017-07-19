public class ThrowWithResources {
    public static void main(String[] args) {
	// traditional way
	MyResource resourceOldStyle = new MyResource("old-style");
	try {
	    throw new Exception();
	}
	catch (Exception e) {
	    System.out.println("Exception " + e + " caught");
	}
	finally {
	    System.out.println("...and finally...");
	    try {
		resourceOldStyle.close();
	    }
	    catch (Exception e) {
		System.out.println("Exception while closing resource");
	    }
	}

	// try-with-resource
	try(MyResource resource = new MyResource("#")) {
	    throw new Exception();
	}
	catch (Exception e) {
	    System.out.println("Exception " + e + " caught");
	}

	// try-with-resource, multiple resources created
	try(MyResource resourceA = new MyResource("A");
	    MyResource resourceB = new MyResource("B");
	    MyResource recourceC = new MyResource("C")) {
	    throw new Exception();
	}
	catch (Exception e) {
	    System.out.println("Exception " + e + " caught");
	}
    }
}

class MyResource implements AutoCloseable {
    MyResource(String name) {
	this.name = name;
	System.out.println("MyResource '" + name + "' created");
    }

    @Override
    public void close() throws Exception {
	System.out.println("MyResource '" + name + "' closed");
    }

    private final String name;
}
