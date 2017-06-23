import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class TypeErasure {
    public static void main(String[] args) {
	GenericClass<Integer> obj = new GenericClass<Integer>();

	Class<?> classObject = obj.getClass();
	
	Field[] fields = classObject.getDeclaredFields();
	for (Field field: fields) {
	    System.out.println(field); // 'private java.lang.Object GenericClass.value'
	}

	Method[] methods = classObject.getDeclaredMethods();
	for (Method method: methods) {
	    System.out.println("methods: " + method); // 'void GenericClass.setValue(java.lang.Object)' 
	}
    }
}

class GenericClass<T> {
    private T value;
    
    void setValue(T value) {
	this.value = value;
    }
}

// *****************************
class SameErasureCompilationError<T> {
    void foo(Object bar) {}
    
    // compilation error, 'name clash: foo(T) and foo(Object) have the same erasure'
    // void foo(T bar) {}
}
