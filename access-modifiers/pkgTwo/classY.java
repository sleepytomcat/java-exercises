package pkgTwo;
public class classY {
    public void useClassX() {
	classX obj = new classX();
	obj.a = 10; // default access
	obj.b = 10; // public access
	obj.c = 10; // protected access
	//obj.d = 10; // private access, inaccessible
    }
}
