import java.util.Random;
public class MultiCatch {
    public static void main(String[] args) {
	try {
	    // will throw exception of type A, or B, or C
	    throwRandomException();
	}
	catch (A | B | C ex) {
	    // At compile-time ex type is "closest common ancestor 
	    // of A, B and C".
	    // In this example compile type of ex is Throwable.
	    System.out.println(ex);
	}   
    }
    
    static void throwRandomException() throws A, B, C {
	Random random = new Random();
	switch (random.nextInt(3)) {
	    case 0:
		throw new A();
	    case 1:
		throw new B();
	    case 2:
		throw new C();
	}
    }
}

class A extends Error {
}

class B extends Throwable {
}

class C extends RuntimeException {
}
