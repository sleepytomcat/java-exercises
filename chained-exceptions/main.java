public class main {
    public static void main(String[] args) {
	try {
	    doSomething();
	}
	catch (CustomException e) {
	    printExceptionInformation(e);
	}
    }

    private static void doSomething() throws CustomException {
	try {
	    doSomethingWithSomeDetails();
	}
	catch (CustomExceptionWithSomeDetails e) {
	    CustomException ex = new CustomException();
	    ex.initCause(e);
	    throw ex;
	}
    }

    private static void doSomethingWithSomeDetails() throws CustomExceptionWithSomeDetails {
	try {
	    doSomethingWithLotsDetails();
	}
	catch (CustomExceptionWithLotsDetails e) {
	    CustomExceptionWithSomeDetails ex = new CustomExceptionWithSomeDetails();
	    ex.initCause(e);
	    throw ex;
	}
    }

    private static void doSomethingWithLotsDetails() throws CustomExceptionWithLotsDetails {
	throw new CustomExceptionWithLotsDetails();
    }

    static void printExceptionInformation(Exception ex) {
	Throwable current = ex;
	System.out.println("Exception caught:");
	String indent = "    ";
	while (current != null) {
	    System.out.println(indent + current.getClass().getName());
	    indent += "    ";
	    current = current.getCause();
	}
	System.out.println("Stack trace:");
	StackTraceElement[] stackTrace = ex.getStackTrace();
	for (StackTraceElement element: stackTrace) {
	    String fileName = element.getFileName();
	    int lineNumber = element.getLineNumber();
	    String className = element.getClassName();
	    String methodName = element.getMethodName();
	    System.out.println("    File " + fileName 
				+ ", line " + lineNumber 
				+ ", class '" + className 
				+ "', method '" + methodName + "'");
	}
    }
}

class CustomException extends Exception {
}

class CustomExceptionWithSomeDetails extends Exception {
}

class CustomExceptionWithLotsDetails extends Exception {
}
