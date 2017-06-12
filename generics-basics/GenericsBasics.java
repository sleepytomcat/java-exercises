public class GenericsBasics {
    public static void main(String[] args) {
	// Integer, Integer are actual type arguments
	Pair<Integer, Integer> checkedObj = new Pair<Integer, Integer>(3, 7);
	System.out.println(checkedObj);

	Pair<Long, String> obj = new Pair<>(3L, "hello"); // types can be inferred by the compiler
	Pair<String, Long> otherObj = new Pair<>();

	// Also can use "raw type" - class without type arguments provided;
	// raw types exist for compatibility reasons (Java had no generics until Java 5).
	// Note that "raw type" can be for generic classes; "normal" classes have no raw types.
	Pair<String, String> uncheckedObj = new Pair(); // also will generate 'unchecked' warning  

	// The other way round, obviously, Ok:
	Pair rawObj = new Pair<String, String>();
    }
}

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

interface Comparable<T> {
   boolean less(T lhs, T rhs);
}

class Comparator implements Comparable<Integer> {
    public boolean less(Integer lhs, Integer rhs) {
	return lhs < rhs;
    }
}

class GenericComparator<T> implements Comparable<T> {
    public boolean less(T lhs, T rhs) {
	return (lhs.toString().compareTo(rhs.toString()) == -1);    
    }
    
    // static method cannot use class' type argument, as class type arguments are associated with class instances;
    // however, static methods can be generic with its own type argument
    static <U> void foo(U data) {
	System.out.println(data.toString());
    }
}

class NonGenericClass {
    <T> String foo(T data) { // non-generic class still can have generic methods
	return "foo:" + data.toString(); 
    }

    <T> String bar(T data) { // note: type argument T is not related to foo<T> in any way
	return "bar:" + data.toString();
    }
}


