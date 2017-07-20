public class BoundedTypeParams {
    public static void main(String[] args) {
	SomeGenericClass<MyClass> obg = new SomeGenericClass<>();
    }
}

class Base {}
interface A {}
interface B {}
interface C {}

// If there's a class in type parameters list - it must go first;
// (and, obviously, there can be only one class there).
class SomeGenericClass<T extends Base & A & B & C> {}

// Custom class that extends/implements all required interfaces
class MyClass extends Base implements A, B, C {}
