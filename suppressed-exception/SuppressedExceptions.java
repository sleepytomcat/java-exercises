public class SuppressedExceptions {
    public static void main(String[] args) {
	try (   CustomResource res1 = new CustomResource("resource-res1");
		CustomResource res2 = new CustomResource("resource-res2")) {
	    // At this point let's throw an exception;
	    // resources res1 and res2 would be automatically closed,
	    // as they implement AutoCloseable.
	    // However, they'll throw an exception, too!
	    throw new CustomExecutionException();
	}
	catch (CustomExecutionException ex) {
	    System.out.println("CustomExecutionException cougth");
	    // Now we expect to get a list of suppressed exceptions -
	    // the ones that were thrown by each res1 and res2 while they were closed.
	    for (Throwable suppressed: ex.getSuppressed())
		System.out.println("Suppressed exception detected: " + suppressed);
	}
	catch (CustomResourceException ex) {
	    // will never reach this line
	}
    }
}

class CustomResource implements AutoCloseable {
    CustomResource(String name) {
	this.name = name;
    }
    
    @Override
    public void close() throws CustomResourceException {
	throw new CustomResourceException(name);
    }

    private String name;
}

class CustomExecutionException extends Throwable {}

class CustomResourceException extends Exception { // should extends Exception, as AutoCloseable.close() throws it
    CustomResourceException(String name) {
	super(name);
    }
}
