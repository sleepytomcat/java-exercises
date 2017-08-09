public class staticMembers {
    static int x = f(5); // can use method call to initialize static members
    static int y = x + 1; // can even reference other static fields; 
    static String text = "hello";
    static String word;
    static int f(int m) {return m*2;}
    
    static { // 'static constructor'
	System.out.println("Static block of code executed");
	word = "hello, world";
    }

    public static void main(String args[]) {
	System.out.println("main() called");

	int m = MyClass.j;
	System.out.println("Referencing static final compile-time-initialized field may not infer class initialization");
	System.out.println("MyClass.j is " + MyClass.j);
	System.out.println("(Note that MyClass static constructor has not been called)");
	System.out.println("...about to reference non-final MyClass field for the first time");
	int h = MyClass.g; // MyClass static constructor(s) will be called just before this statement
    }
}

class MyClass {
    static {
	System.out.println("MyClass static constructor called");
    }

    static final int j = 5;
    static int g = 0;

    static {
	System.out.println("Static constructors (if more than one) are called in order of declaration");
    }
}
