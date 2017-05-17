class Exceptions {
    public static void main(String[] args) {
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
    }
}

class CustomException extends RuntimeException {
}

class CustomDetailedException extends CustomException {
}
