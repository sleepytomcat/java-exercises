package main;
public class StringIntern {
    public static void main(String[] args) {
	String hello = "Hello";
	String hel = "Hel";
	String lo = "lo";

	compareAndPrint(hello, "Hello");
	compareAndPrint(hello, otherPackage.OtherPackageClass.hello);
	compareAndPrint(hello, (hel + lo));
	compareAndPrint(hello, (hel + lo).intern());
    }
    
    static void compareAndPrint(String str1, String str2) {
	System.out.print('\'' + str1 + '\'');
	System.out.print(" ");
	System.out.print('\'' + str2 + '\'');
	System.out.print(" same? ");
	System.out.println(str1 == str2);
    }
}
