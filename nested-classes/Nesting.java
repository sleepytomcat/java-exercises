public class Nesting {
    public static void main(String[] args) {
	Outer obj = new Outer();	
	obj.testInner();
	obj.testNested();

	Outer.NestedStatic n = new Outer.NestedStatic();
	n.doSomething(obj);
	
	// objects of inner classes cannot be constructed outside of outer class methods 
    }
}

class Outer {
    private int outerData = 10;

    static class NestedStatic {
	void doSomething(Outer outer) {
	    System.out.println(outer.outerData); // can access private members of outer class 
	}
	int nestedData = 10;
    }

    class Inner {
	void doSomething() {
	    System.out.println(outerData);
	}
	int innerData = 20;
    }

    void testInner() {
	Inner inner = new Inner();
	inner.doSomething();
	inner.innerData = 30;
    }

    void testNested() {
	NestedStatic nested = new NestedStatic();
	nested.doSomething(this);
	nested.nestedData = 40;
    }
}
