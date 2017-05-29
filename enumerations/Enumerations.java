public class Enumerations {
    public static void main(String[] args) {
	Colors c = Colors.GREEN;
	System.out.println(c.name());

	switch(c) {
	    case RED: // note enum class name is not requied
		System.out.println("a is red");
		break;
	    case GREEN:
		System.out.println("a is green");
		break;
	    case BLUE:
		System.out.println("a is blue");
		break;
	}

	// interestingly, values() method does not come from Enum class;
	// instead, according to documentation, it's "added by compiler".
	for (Berries berry: Berries.values()) {
	    System.out.println(berry + "'s color is " + berry.getColor());
	    System.out.println(berry + " ordinal is " + berry.ordinal());
	}

	Colors red = Colors.RED;
	Colors anotherRed = Colors.RED;
	Colors blue = Colors.BLUE;
	System.out.println(red == anotherRed);
	System.out.println(red == blue); // safe to use == to compare enums

	Berries a = Berries.valueOf("Watermelon");
	System.out.println(a);

	try {
	    Berries b = Berries.valueOf("unknown");
	    System.out.println(b);
	}
	catch (IllegalArgumentException e) {
	    System.out.println(e.getMessage());
	}
    }
}

// Inherits from Enum
enum Colors{
    RED, GREEN, BLUE;
}

enum Berries {
    Blueberry(Colors.BLUE), 
    Watermelon(Colors.GREEN),
    Strawberry(Colors.RED);

    Berries(Colors color) {
	this.color = color;
    }

    Colors getColor() {
	return color;
    }

    private Colors color;
}
