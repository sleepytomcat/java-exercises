package main;
public class StringIntern {
    public static void main(String[] args) {
	String hello = "Hello";
	String hel = "Hel";
	String lo = "lo";

	System.out.println(hello == "Hello"); // true
	System.out.println(hello == (hel + lo)); // false
	System.out.println(hello == (hel + lo).intern()); // true
	System.out.println(hello == otherPackage.OtherPackageClass.hello); // true
    }
}
