public class Nesting {
    public static void main(String[] args) {
	Outer obj = new Outer();	
	obj.testInner();
	obj.testNested();

	Outer.NestedStatic n = new Outer.NestedStatic();
	n.doSomething(obj);
	
	// objects of inner classes can be constructed only with reference to outer class instance:
	Outer outerObj = new Outer();
	Outer.Inner innerObj = outerObj.new Inner();
	innerObj.doSomething(); // note this instance has access to "parent" object data
	
	// Interfaces can have inner classes, too:
	MyInterface.MyClass instance = new MyInterface.MyClass();

	// It's even possible to inherit from inner classes:
	X x = new X();
	Derived derived = new Derived(x);
    }
}

class Outer {
    private int outerData = 10;
    String text = "text-from-outer-class";

    static class NestedStatic {
	void doSomething(Outer outer) {
	    System.out.println(outer.outerData); // can access private members of outer class 
	}
	int nestedData = 10;
    }

    class Inner {
	void doSomething() {
	    System.out.println(outerData);
	    System.out.println(text);
	    System.out.println(Outer.this.text);
	}
	int innerData = 20;
	String text = "text-from-inner-class";    
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

////////////////////////////////////////////////
interface MyInterface {
    void f();
    MyClass g();
    class MyClass {
	void x(){
	    System.out.println("Interfaces can have implemented inner classes, too.");
	}
    }
}

////////////////////////////////////////////////
class X {
    X() {System.out.println("Object of class X constructed");}
    class Y {
	Y(int value){System.out.println("Object of type X.Y constructed");}
    }
}

class Derived extends X.Y {
    Derived(X enclosingInstance) {
	enclosingInstance.super(1);
	System.out.println("Object of class Derived constructed");
    }
}
