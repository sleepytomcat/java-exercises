public class staticMembers {
    static int x = 10;
    static String y = "hello";
    static {
	System.out.println("Static block of code executed");
    }

    public static void main(String args[]) {
	System.out.println("main() called");
    }
}


