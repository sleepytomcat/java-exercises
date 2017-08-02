public class InvokingOverloadedConstructor {
    public static void main(String[] args) {
	Object obj = new MyClass(); // overloaded constructor MyClass(1,1) will be called from MyClass()
    }
}

class MyClass {
    MyClass(int x, int y) {
	System.out.println("MyClass(" + x + "," + y + ") constructor called");
	this.x = x;
	this.y = y;
    }

    MyClass() {
	this(0,0); // must be first statement in the constructor
	System.out.println("MyClass() constructor called");
    }

    int x;
    int y;
}
