import java.lang.reflect.Method;

public class BridgeMethods {
    public static void main(String[] args) {
	SomewhatComparableObject obj = new SomewhatComparableObject();

	// Prints two methods, while one is expected;
	// one 'as declared', and one more synthetic 'bridge' method.
	// Bridge method implements @Override behavior (remember type erasure?).
	for (Method method: obj.getClass().getDeclaredMethods()) {
	    System.out.println(method);
	}
    }
}

interface PartialCompare<T> {
    boolean less(T lhs, T rhs);
}

class SomewhatComparableObject implements PartialCompare<SomewhatComparableObject> {
    @Override
    public boolean less(SomewhatComparableObject lhs, SomewhatComparableObject rhs) {
	return false;
    }
}
