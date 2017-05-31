public class CheckedUnchecked {
    public static void main(String[] args) {
	try {
	    foo();
	}
	catch (ClassNotFoundException e) {
	    // must catch checked-semantics exceptions
	}

	// try/catch optional for unchecked exceptions
	bar();	// will throw ArithmeticException, which 
		//will propagate out of main().
    }

    // Throwable - base class for all exceptions in Java
    // Error - all "hardware-style" problems; "unchecked"-sematics;
    // RuntimeError - all "local" problems, like arithmetic errors; "unckecked" semantics;
    // Exception - "checked" semantics, reasonable parent class for custom exception classes.
    // "Unchecked" semantics - not required to declare in throws statement;
    // "checked" must be declares in throws statement.
    // Checked exception provide additional API (extra to method input params 
    // and returned value) for method user; unchecked exception signal about
    // (potentially unrecoverable) execution errors.

    // Checked semantics 
    static void foo() throws ClassNotFoundException {
	throw new ClassNotFoundException();
    }

    // Unchecked semantics - ArithmeticException is RuntimeException 
    static void bar() {
	throw new ArithmeticException();
    }
}
