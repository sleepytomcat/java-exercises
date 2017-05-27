class comparison {
    public static void main(String[] args) {
	String a = "12";
	String b = "34";
	String ab = a + b;

	if (ab == "1234")
	    System.out.println("if statement: ab is \"1234\"");
	else
	    System.out.println("if statement: ab is not \"1234\"");

	switch(ab) {
	    case "1234":
		System.out.println("switch statement: ab is \"1234\"");
		break;
	    default:
		System.out.println("switch statement: ab is not \"1234\"");
	}

	while(ab == "1234") {
	    System.out.println("while loop: ab is \"1234\"");
	}
    }
}

