public class GenericsBasics {
    public static void main(String[] args) {
	// Integer, Integer are actual type arguments
	Pair<Integer, Integer> checkedObj = new Pair<Integer, Integer>(3, 7);
	System.out.println(checkedObj);

	Pair<Long, String> obj = new Pair<>(3L, "hello"); // types can be inferred by the compiler from argument types
	Pair<String, Long> otherObj = new Pair<>(); // 'diamond' can be used with generic classes only; 
						    // type inferred from lvalue
	bar(new Pair<>()); // type inferred from expected argument type

	new Pair<>(); // type inferred as <Object, Object>

	// Also can use "raw type" - class without type arguments provided;
	// raw types exist for compatibility reasons (Java had no generics until Java 5).
	// Note that "raw type" can be for generic classes; "normal" classes have no raw types.
	Pair<String, String> uncheckedObj = new Pair(); // also will generate 'unchecked' warning  

	// The other way round, obviously, Ok:
	Pair rawObj = new Pair<String, String>();
	
	// 'Regular' class with generic constructor argument
	NonGenericClass ngc = new <Integer>NonGenericClass(128); // type argument explicitly declared
	NonGenericClass ngc2 = new NonGenericClass("hello"); // type argument inferred

	// 'regular' class with generic method(s) 
    	String text = ngc.foo(1024L); // type argument inferred
	String text2 = ngc.<String>foo("hello"); // type argument explicitly declared
 
	// Generic class, also with generic methods
	GenericClassWithGenericMethod<Integer> gcwgm = new GenericClassWithGenericMethod<>();
	gcwgm.foo("hello");
	gcwgm.<Integer>foo(128);
    }

    static void bar(Pair<Integer, Integer> pair) {
	pair = new Pair<Integer, Integer>();
	System.out.println(pair);
    }
}

//*********************************
class Pair<K, V> { // K, V are type parameters
    Pair() {
    }

    Pair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    @Override
    public String toString() {
	return "{key:" + key + ", value:" + value + "}";
    }

    private K key;
    private V value;
}

//*********************************
interface Comparable<T> {
   boolean less(T lhs, T rhs);
}

class Comparator implements Comparable<Integer> {
    @Override // bridge method actually generated here, because of type erasure
    public boolean less(Integer lhs, Integer rhs) {
	return lhs < rhs;
    }
}

class GenericComparator<T> implements Comparable<T> {
    public boolean less(T lhs, T rhs) {
	return (lhs.toString().compareTo(rhs.toString()) == -1);    
    }
    
    // Static method cannot use class' type argument, as in reality generic type arguments do not really
    // generate new classes - instead, with type erasure, same raw type used with every generic class
    // (which means all 'specialized classes' of a generic class actually share same static data/methods.
    // However, static methods can be generic with its own type argument(s).
    static <U> void foo(U data) {
	System.out.println(data.toString());
    }
}

//*********************************
class NonGenericClass {
    <U> NonGenericClass(U data) { // constructors can be generic, too
	System.out.println(data.toString());
    }

    <T> String foo(T data) { // non-generic class still can have generic methods
	return "foo:" + data.toString(); 
    }

    <T> String bar(T data) { // note: type argument T is not related to foo<T> in any way
	return "bar:" + data.toString();
    }
}

//*********************************
class GenericClassWithGenericMethod<T> {
    T data;
    <V> void foo(V param) {
	System.out.println(param);
    }
} 

//*********************************
interface A {}
interface B {}
class X {}

class GenericClassWithBoundedType<T extends X & A & B> {
    // can be parametrized with type that extends X, also implements both A and B
}
