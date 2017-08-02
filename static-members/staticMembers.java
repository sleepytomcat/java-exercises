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

	System.out.println("...about to reference MyClass for the first time");
	int h = MyClass.g; // MyClass static constructor(s) will be called just before this statement
    }
}

class MyClass {
    static {
	System.out.println("MyClass static constructor called");
    }

    static int g = 0;

    static {
	System.out.println("Static constructors (if more than one) are called in order of declaration");
    }
}
