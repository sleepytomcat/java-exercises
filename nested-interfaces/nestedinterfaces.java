class NestedInterfaces {
    public static void main(String[] args) {
	I a = new A();
	I.Nested b = new B();
	WithNestedInterfaces c = new WithNestedInterfaces();
	WithNestedInterfaces.NestedPublic d = new X();
    }
}

interface I {
    void foo();
    // 'public' allowed, but does not change anything, as interface members are public by default
    public interface Nested {
	void bar();
    }
}

class A implements I {
    public void foo(){
    }
}

class B implements I.Nested {
    public void bar() {
    }
}

class WithNestedInterfaces {
    int x;
    void someMethod() {
    }

    // can be 'public'
    public interface NestedPublic {
	void foo();
    }

    // also can be 'private' or 'protected'
    private interface NestedPrivate {
	void bar();
    }

    // interface NestedPrivate declared as 'private', so's only visible within same class 
    static class NestedPrivateImplemented implements NestedPrivate {
	public void bar() {
	}
    }
}

class X implements WithNestedInterfaces.NestedPublic {
    public void foo() {
    }
}
