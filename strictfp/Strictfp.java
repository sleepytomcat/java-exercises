public class Strictfp {
    public static void main(String[] args) {
    }
}

// interface can be marked strictfp - all implementing classes will be implicitly strictfp, too
strictfp interface Calculations {}

interface SomeInterface {
    // individual interface methods cannot be strictfp, as well as any other abstract methods 
    // strictfp f();
}

// whole class can be marked strictfp
strictfp class Calc{}

class OtherCalc {
    strictfp void f() {double x = 2.0 + 3.0;} // individual methods with implementation can be strictfp
}
