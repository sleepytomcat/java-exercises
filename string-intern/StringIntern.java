public class StringIntern {
    public static void main(String[] args) {
	String hello = "Hello";
	String hel = "Hel";
	String lo = "lo";

	System.out.println(hello == "Hello");
	System.out.println(hello == (hel + lo));
	System.out.println(hello == (hel + lo).intern());
    }
}
