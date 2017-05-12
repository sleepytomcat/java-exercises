public class Literals {
    public static void main(String[] args) {
	byte a = -10;
	short b = -30;
	int c = -1000;
	long d = -1_000_000_000L;
	float negativeInfinity = -1f/0f; 
	float e = -123.456f;
	float f = Float.NaN;
	double g = -1024E45d; 
	double h = 0xff; // hex numeral
	double i = 0b0101; // binary numeral
	double j = 07d; // octal numeral
	double k = Double.NaN;
	boolean toBeOrNotToBe = true;
	char l = 'A';
	char m = '\\';
	char n = '\n';
	char o = '\uFFFF';
	Object p = null;
	String q = "Hello";
	String r = "Hello," + " " + "world!";
    }
}
