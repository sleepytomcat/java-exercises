class FinalDeclarations {
    final int x = 10;
    final int y; // 'blank final'
    int z;

    FinalDeclarations() {
	y = 25; // OK to initialize 'blank final' in constructor
    }

    FinalDeclarations(int z) {
	y = 30; // Actually, all constructors must initialize 'blank final'
    }

    FinalDeclarations(double z) {
	this(1); // will initialize y which is 'blank final'
    }

    void f(final int x) {
	// cannot assign value to argument declared 'final'
	// x = 1;
    }

    public static void main(String[] args) {
	final FinalDeclarations obj = new FinalDeclarations();
	// obj  = null; // cannot change final data
	// obj.y = 15; // cannot change final data
	obj.z = 100; // Ok, as obj.z is not 'final' (while obj itself is 'final')
    }
}

class A {
    final void g(){}
}

class B extends A {
    // cannot override 'final' methods
    // @Override
    // void g() {}
}

final class X {}
// cannot inherit from 'final' class
// class Y extends X {}
