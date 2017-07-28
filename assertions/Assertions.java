public class Assertions {
    // Assertions are off by default, and assert statement(s) are not evaluated;
    // to enable assertions:
    // java -ea Assertions
    //
    // to enable assertions in a package
    // java -ea:pkg1.subpkg1 SomeMainClass
    // 
    // to enable assertions in a package and all subpackages
    // java -ex:pkg1.subpkg1... SomeMainClass
    //
    // to enable assertions in a particular class
    // java -ex:pkg1.SomeClass SomeMainClass
    //
    // to enable assertions in a package, particular class, and disable assertions in another class
    // java -ea:pkg1.SomeClass -ea:pkg1.subpkg1... -da:pkg1.subpkg1.SomeOtherClass SomeMainClass
    public static void main(String[] args) {
	int x = 10;
	assert x > 0;
	assert x % 2 == 0 : "x must be even number"; // second expression must yield value to form error message 

	// it's technically possible to use try/catch with assertions,
	// but that's not something that should happen in real world.
	try {
	    assert x < 5 : "x must be less than 5";
	}
	catch (AssertionError ex) {
	    System.out.println("ASSERTION FAILED WITH MESSAGE: '" + ex.getMessage() + "', THEN AssertionError CAUGHT");
	}
 
	// it's possible to enable and disable assertions per class or package
	// run with params:
	// java -ea:Assertions -ea:Two -da:One Assertions

	One obj1 = new One();
	Two obj2 = new Two();

	obj1.f();
	obj2.g();
    }
}

class One {
    void f() {
	assert false : "ASSERTION FAILED IN CLASS 'ONE'";
    }
}

class Two {
    void g() {
	assert false : "ASSERTION FAILED IN CLASS 'TWO'";
    }
}
