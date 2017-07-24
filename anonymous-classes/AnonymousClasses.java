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
	};

	obj.f();
	obj.g();

	String localString = "some text";
	MyClass obj2 = new MyClass() {
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
    void h() {System.out.println("MyClass.h() called");}
}
