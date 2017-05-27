class StaticMethods {
    public static void main(String[] args) {
	System.out.println("StaticMethods.main() entering");
	MyInterface.foo();
	MyClass.bar();
	System.out.println("StaticMethods.main() exiting");
    }
}

interface MyInterface {
    static void foo() {
	System.out.println("MyInterface.foo() called");
    }
}

class MyClass {
    // Static init called when class is loaded;
    // class is loaded when referenced.
    static {
	System.out.println("MyClass static init #1");
    }

    static void bar() {
	System.out.println("MyClass.bar() called");
    }

    static {
	System.out.println("MyClass static init #2");
    }
}
