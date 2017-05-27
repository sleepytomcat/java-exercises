class defaultmethods {
    public static void main(String[] args) {
	MyClass obj = new MyClass();
	obj.foo();
    }
}

interface A {
    default void foo() {
	System.out.println("A.foo() called");
    }
}

interface B {
    default void foo() {
	System.out.println("B.foo() called");
    }
}

class MyClass implements A, B {
    public void foo() {
	A.super.foo();
	B.super.foo();
    }
}
