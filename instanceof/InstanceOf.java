public class InstanceOf {
    public static void main(String[] args) {
	Object obj = new MyClass();
	System.out.println("obj is A: " + (obj instanceof A));
	System.out.println("obj is B: " + (obj instanceof B));
	System.out.println("obj is C: " + (obj instanceof C));
	System.out.println("obj is D: " + (obj instanceof D));
	System.out.println("obj is MyClass: " + (obj instanceof MyClass));
    }
}

interface A {}
interface B {}
interface C {}
class D {}
class MyClass extends D implements A, B {}
