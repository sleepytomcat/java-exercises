package pkgTwo;
public class classX {
    int a; // default access - visible to classes inside same package, invisible outside of this package
    public int b; // public access - visible everywhere, any package
    protected int c; // protected access - visible to child classes in other packages, and to all classes in same package
    private int d; // private access - invisible for anyone outside this same class
}
