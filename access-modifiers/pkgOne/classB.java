package pkgOne;
class classB extends pkgTwo.classX {
    void useClassX() {
	// a = 10; // inaccessible
	b = 10; // declared public in pkgTwo.classX
	c = 10; // declared protected in pkgTwo.classX
	// d = 10; // inaccesible
    }
}
