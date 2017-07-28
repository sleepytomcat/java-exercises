class AnonymousClasses {
    public static void main(String[] args) {
	I obj = new I() {
	    // defining interface methods
	    @Override
	    public void f() {System.out.println("Anonymous class implements I.f()");}
	    @Override
	    public void g() {System.out.println("Anonymous class implements I.g()");}
	    // can add new methods, too
	    public void x() {System.out.println("New method x()");};
	    // can have 'instance initializer block' which is 
	    // mostly same as static initializer block - but not static:
	    {
		System.out.println("Anonymous classes cannot have a 'real' constructors, so they can use initializer blocks");
	    }
	};

	obj.f();
	obj.g();

	String localString = "some text";
	// Note: base class for anonymous class still can get a constructor argument(s)
	MyClass obj2 = new MyClass(123) {
	    @Override
	    void h() {
		super.h();
		System.out.println("Anonymous adds behavior to MyClass.h()");
		// this is the interesting part: anonymous classes (just like local classes)
		// can access local data:
		System.out.println("Outer class data: '" + localString + "'");
	    }
	};

	obj2.h();
    }
}

interface I {
    void f();
    void g();
}

class MyClass {
    MyClass(int arg) {System.out.println("MyClass instance constructed with argument " + arg);}
    void h() {System.out.println("MyClass.h() called");}
}
