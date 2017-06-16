public class LocalClasses {
    public static void main(String[] args) {
	Test test = new Test();
	test.foo();
    }
}

class Test {
    void foo() {
	final int localFinalData = 1;
	int localEffectivelyFinalData = 2;
   
	class Local {
	    void doSomething() {
		System.out.println(localFinalData); // OK
		System.out.println(localEffectivelyFinalData); // OK
		System.out.println(instanceData); // OK
	    }

	    final static int x = 3; // final, primitive type - "constant" value
	    final static String text = "hello"; // final, String type (special case) - "constant" value
	    // however, there cannot be nested interfaces or static methods or static non-constant values (see above)
	}
	
	Local localObj = new Local();
	localObj.doSomething();
    }

    int instanceData = 3;
}

