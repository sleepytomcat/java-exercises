public class Loops {
    public static void main(String[] args) {
	for (int i = 0; i < 5; ++i)
	    System.out.println("i: " + i);

	for (int l = 0, m = 0; l + m < 10; l++, m++)
	    System.out.println("l: " + l + ", m: " + m);

	int[] numbers = {1, 1, 3, 5, 8, 13};
	for (int i: numbers)
	    System.out.println("i: " + i);

	String[] words = {"hello", "world"};
	for (String word: words)
	    System.out.println(word);

	boolean done = false;
	for (;!done;) {
	    System.out.println("wow!");
	    done = true;
	}

	for (;;) {
	    System.out.println("more wow!");
	    break;
	}

	for (int i = 0; i < 10; ++i) {
	    if (i%2 == 0)
		continue;
	    System.out.println("i: " + i);
	}

	int x = 5;
	while (x > 0) {
	    x--;
	    System.out.println("x: " + x);
	}

	int f = 0;
	do {
	    System.out.println("f: " + f);
	    f++;
	} while (f < 5);
    }
}
