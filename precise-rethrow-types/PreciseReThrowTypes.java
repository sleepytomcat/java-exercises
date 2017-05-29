import java.util.Random;
public class PreciseReThrowTypes {
    public static void main(String[] args) {
    }

    void foo() throws A, B {
	try {
	    throwRandomException(); // throws checked A or B
	}
	catch (Exception ex) {
	    throw ex;	// ex of type Exception is being re-thrown here;
			// however, compiler is wise enough to note
			// that actual (checked) type of ex could be 
			// only A or B.
			// Note that 'throws' statement in method definition.
	}
    }

    void throwRandomException() throws A, B {
	Random random = new Random();
	switch (random.nextInt(2)) {
	    case 0:
		throw new A();
	    case 1:
		throw new B();
	}
    }
}

class A extends Exception {
}

class B extends Exception {
}
