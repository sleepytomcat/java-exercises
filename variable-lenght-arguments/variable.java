class variable {
    public static void main(String[] args) {
	f(1);
	f(1, 2, 3, 4);
	f(1, 2, "hello", "world");
    }

    private static void f(int x) {
        System.out.println("(" + x + ")");
    }
	
    private static void f(int...args) {
	System.out.print("([");
	for (int i = 0; i < args.length; ++i) {
	    System.out.print(args[i]);
	    if (i < args.length - 1)
		System.out.print(",");
	}
        System.out.println("])");
    }

    private static void f(int a, int b, String ... args) {
	String text = String.join(",", args);
	System.out.println("(" + a + "," + b + "," + "[" + text + "])");
    }
}
