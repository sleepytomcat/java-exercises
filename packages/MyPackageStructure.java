public class MyPackageStructure {
   public static void main(String[] args) {
       // Package names and public class names must mimic directory tree structure,
       // as this is the way for ClassLoader to find and load them when needed.
       pkg.subpkg.MyClass obj = new pkg.subpkg.MyClass();
       obj.foo();
       obj.bar();
   }
}
