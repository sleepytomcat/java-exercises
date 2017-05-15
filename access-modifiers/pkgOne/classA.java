package pkgOne;
public class classA {
    public static void main(String[] args) {
	classB obj = new classB();
	obj.useClassX();
	
	pkgTwo.classY y = new pkgTwo.classY();
	y.useClassX();

	pkgTwo.classX x = new pkgTwo.classX();
	// x.a = 10; // inaccessible
	x.b = 10;
	// x.c = 10; // inaccessible
	// x.d = 10; // inaccessible
    }
}
