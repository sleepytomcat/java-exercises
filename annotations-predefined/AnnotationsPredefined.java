import java.lang.Deprecated;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.lang.SafeVarargs;
import java.lang.FunctionalInterface;

// applied to other annotations, 'meta-annotations'
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;

// ************** @Deprecated
// Annotation @Deprecated could be applied to different entities: 
// CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE
// 
// "A Java compiler must produce a deprecation warning when a type, method, field, or constructor 
// whose declaration is annotated with the annotation @Deprecated is used (i.e. overridden, invoked, 
// or referenced by name), unless:
// 
// The use is within an entity that is itself annotated with the annotation @Deprecated;
// The use is within an entity that is annotated to suppress the warning with the annotation @SuppressWarnings("deprecation");
// The use and declaration are both within the same outermost class.
//
// Use of the @Deprecated annotation on a local variable declaration or on a parameter declaration has no effect."
public class AnnotationsPredefined {
    public static void main(String[] args) {
	MyClass obj = new MyClass();
	obj.bar(); // no @Deprecated warning, as MyClass.bar() itself is not deprecated
	obj.foo(); // @Deprecated warning
    }
}

class MyClass {
    /**
    * @deprecated (this is recommended for javadoc)
    * Old and outdated. 
    */
    @Deprecated
    void foo(){
    }

    void bar(){
	foo();	// this will not generate a warning, because warning would be issued only when 
		// @Deprecated method called by not-deprecated class, or overridden by non-deprecated class   
    }
}

class MyOtherClass extends MyClass {
    @Override
    void foo() { // @Deprecated warning - overriding deprecated method of base class
    }
}

// ************** @Override
class A {
    void foo() {}
}

class B extends A{
    @Override // optional, but helps compiler to detect overriding issues
    void foo() {}
}

// ************** @SuppressWarnings
class DeprecatedClass { 
    @Deprecated
    void foo() {
    }
}

class UpToDateClass extends DeprecatedClass {
    @Override
    @SuppressWarnings({"unchecked"}) // vendors may introduce all sorts of warning classes identified by string name
    void foo() { 
	java.util.TreeSet set = new java.util.TreeSet();
	set.add("abc"); // would generate an 'unchecked' warning, but it's suppressed with @SuppressWarnings
    }
}

// ************* @SafeVarargs
class SafeVarargsExample{
    // Note: this example is not really "safe".
    // @SafeVarargs can be applied to static or final methods (other methods could be overridden,
    // and there's no guarantee that would be done in a safe way).
    @SafeVarargs 
    static void foo(java.util.List<String>... stringLists) {
	String s = stringLists[0].get(0); // would generate an unsafe varargs warning, but it's suppressed with the annotation
    }
}

// ************** FunctionalInterface
// Optional, however, once @FunctionalInterface applied to a type, compiler would check if 
// - the type is an interface type and not an annotation type, enum, or class;
// - the annotated type satisfies the requirements of a functional interface.
@FunctionalInterface
interface Functor {
    void doSomething();
}

// ************** Retention;
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME) // also could be SOURCE, CLASS.
@interface MyAnnotation {
    String value();
}

// ************** Documented;
@Documented
@interface DocumentedAnnotation {
}

@DocumentedAnnotation
class ClassToBeDescribedByJavadoc { 
    // Normally, javadoc will not mention any annotations applied to types;
    // however, our custom @DocumentedAnnotation is, itself, annotated as @Documented,
    // so it will be included in the generated documentation.
    // Note: javadoc documents only public API's.
}

// ************** Target;
// Defines where annotation can be applied, can be one or an array of 
// ANNOTATION_TYPE
// CONSTRUCTOR
// FIELD
// LOCAL_VARIABLE
// METHOD
// PACKAGE
// PARAMETER
// TYPE
// TYPE_PARAMETER
@Target(java.lang.annotation.ElementType.TYPE)
@interface MyOtherAnnotation {
    String value();
}

// ************** Inherited;
// Makes annotation inheritable (normally annotations are NOT inherited.
// Affects only annotations applied to classes.
@Inherited
@interface InheritedAnnotation {
    String value();
}

@InheritedAnnotation("applied to base, but will be inherited")
class Base {
}

class Derived extends Base { // class Derived will have the same @InheritedAnnotation as a Base class
}

// ************** Repeatable;
// For compatibility, annotations still can not be repeated on the same element;
// instead, they can be stacked inside 'container' annotation.

@interface ContainerAnnotation {
    RepeatableAnnotation[] value();
}

@java.lang.annotation.Repeatable(ContainerAnnotation.class)
@interface RepeatableAnnotation {
    int value();
}

// Now RepeatabelAnnotation can be repeated (however, in reality they all stored in ContainerAnnotation;
// Java 8 provides some helper methods to access them.
@RepeatableAnnotation(3)
@RepeatableAnnotation(5)
@RepeatableAnnotation(7)
class MultipleAnnotationsApplied {
}
