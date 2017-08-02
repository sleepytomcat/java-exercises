import static java.lang.Math.sin; // importing static method sin()
import static java.lang.Math.cos; // importing static method cos()

public class StaticImports {
    public static void main(String[] args) {
	// Normally, next line would look like
	// double x = Math.sin(1.0) + Math.cos(1.0);
	// however, 'import static' significantly simplifies this.
	double x = sin(1.0) + cos(1.0);
    }
}
