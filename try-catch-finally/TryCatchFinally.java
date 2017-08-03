class TryCatchFinally {
    public static void main(String[] args) throws Exception {
	try {
	    throw new CustomException();
	}
	catch (CustomDetailedException e) {
	    System.out.println("Got CustomException");
	}
	catch (CustomException e) {
	    System.out.println("Got CustomDetailedException");
	    for (StackTraceElement stackTraceElement: e.getStackTrace()) {
		String className = stackTraceElement.getClassName();
		String fileName = stackTraceElement.getFileName();
		int lineNumber = stackTraceElement.getLineNumber();
		String methodName = stackTraceElement.getMethodName();
		System.out.println("file " + fileName + " line " + lineNumber + " class " + className + " method " + methodName);
	    }
	}
	finally {
	    System.out.println("Will be executed... finally");
	}

	try {
	    System.out.println("finally is optional");
	}
	catch (Exception e) {
	}

	try {
	    System.out.println("catch is optional");
	}
	finally {
	}

	try (AutoCloseable resource = new CustomResource()) {
	    System.out.println("try-with-resources can be used without catch and finally");
	}

	System.out.println("finally will be executed even if 'return' is the reason to exit 'try': " + f()); 
    }

    static int f() {
	try {
	    return 1; // 'finally' clause should be executed anyway
	} 
	finally {
	    return -1; // -1 will be returned by f()
	}
    }
}

class CustomException extends RuntimeException {
}

class CustomDetailedException extends CustomException {
}

class CustomResource implements AutoCloseable {
    public void close() {};
}

class FinallyVsReturn {

}
