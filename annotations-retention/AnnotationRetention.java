import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationRetention {
    @MyAnnotationA
    @MyAnnotationB
    @MyAnnotationC
    public static void main(String[] args) {
    }
}

// visible in the source code only - 
// useful for static code analyzer, compiler, etc.
@Retention(RetentionPolicy.SOURCE) 
@interface MyAnnotationA {
}

// visible in bytecode, but not at runtime -
// useful for code obfuscators, custom JVM implementations, etc.
@Retention(RetentionPolicy.CLASS)
@interface MyAnnotationB {
}

// visible at runtime
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationC {
}
