public class MethodReferences {
    public static void main(String[] args) {
	// Reference to a static method
	callReferenceToStaticMethod(MyClass::staticMethod);
	// ...which is same as lambda expression
	callReferenceToStaticMethod(text -> MyClass.staticMethod(text));

	// Reference to an instance method of a particular object
	MyClass obj = new MyClass("*");
	callReferenceToInstanceMethodOfParticularObject(obj::instanceMethod);
	// ...which is same as lambda expression
	callReferenceToInstanceMethodOfParticularObject(text -> obj.instanceMethod(text));
    
	// Reference to class constructor
	MyClass otherObj = constructWithFunctor(MyClass::new);
	// ...which is same as lambda expression
	constructWithFunctor(() -> new MyClass());

	// Reference to class constructor, with argument(s)
	MyClass anotherObj = constructWithFunctor(MyClass::new, "$");
	// ...which is same as lambda expression
	constructWithFunctor(str -> new MyClass(str), "$");
	
	// Reference to an instance method of an arbitrary object of particular type
	callReferenceToMethodOfArbitraryObjectOfParticularType(MyClass::instanceMethod);
	// ...which is same as lambda expression
	callReferenceToMethodOfArbitraryObjectOfParticularType((object, argument) -> object.instanceMethod(argument));
    }

    static void callReferenceToStaticMethod(Functor f) {
	f.apply("MyClass static method called");
    }
    
    static void callReferenceToInstanceMethodOfParticularObject(Functor f) {
	f.apply("Method of particular MyClass instance called");
    }
    
    static MyClass constructWithFunctor(FunctorNew f) {
	System.out.println("Constructing MyClass instance without arguments");
	return f.instantiate();
    }

    static MyClass constructWithFunctor(FunctorNewWithArgument f, String arg) {
	System.out.println("Constructing MyClass instance with argument");
	return f.instantiate(arg);
    }

    static void callReferenceToMethodOfArbitraryObjectOfParticularType(InstanceMethodCall f) {
	MyClass obj = new MyClass("&");
	f.apply(obj, "Arbitrary object of particular type method called");
    }
}

class MyClass {
    MyClass() {decorator = "^";}
    MyClass(String decorator) {this.decorator = decorator;}
    void instanceMethod(String text) {System.out.println(decorator + text + decorator);}
    static void staticMethod(String text) {System.out.println(text);}
    private String decorator;
}

@FunctionalInterface
interface Functor {
    void apply(String text);
}

@FunctionalInterface
interface FunctorNew {
    MyClass instantiate();
}

@FunctionalInterface
interface FunctorNewWithArgument {
    MyClass instantiate(String t);
}

@FunctionalInterface
interface InstanceMethodCall {
    void apply(MyClass obj, String arg);
}
