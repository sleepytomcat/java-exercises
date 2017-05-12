public class Literals {
    public static void main(String[] args) {
	byte a = -10;
	short b = -30;
	int c = -1000;
	long d = -1_000_000_000L;
	float negativeInfinity = -1f/0f; 
	float e = -123.456f;
	double f = -1024E45d; 
	double g = 0xff; // hex numeral
	double h = 0b0101; // binary numeral
	double i = 07d; // octal numeral
	boolean toBeOrNotToBe = true;
	char j = 'A';
	char k = '\\';
	char l = '\n';
	char m = '\uFFFF';
	Object n = null;
	String o = "Hello";
	String p = "Hello," + " " + "world!";
    }
}
