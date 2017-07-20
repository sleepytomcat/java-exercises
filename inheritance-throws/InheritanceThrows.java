public class InheritanceThrows {
    public static void main(String[] args) {
	try {
	    I obj = new Derived();
	    obj.f();
    	}
	catch(DerivedDerivedException e) {
	    System.out.println("DerivedDerivedException caught");
	}
	catch(DerivedException e) {
	    System.out.println("DerivedException caught");
	}
	catch(BaseException e) {
	    System.out.println("BaseException caught");
	}
    }
}

class BaseException extends Throwable {}
class DerivedException extends BaseException {}
class DerivedDerivedException extends DerivedException {}

interface I {
    void f() throws BaseException;
}

class Base implements I {
    public void f() throws DerivedException {
	throw new DerivedException();
    }
}

class Derived extends Base {
    public void f() throws DerivedDerivedException {
	throw new DerivedDerivedException();
    }
}
