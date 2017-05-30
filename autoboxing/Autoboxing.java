import java.util.LinkedList;
import java.util.List;

public class Autoboxing {
    public static void main(String[] args) {
	Boolean a = true;
	Character b = 'a';
	Byte c = 6;
	Short d = 7;
	Integer e = 7;
	Long f = 10L;

	System.out.println(e.byteValue());
	System.out.println(e.doubleValue());
	System.out.println(e.floatValue());
	System.out.println(e.intValue());
	System.out.println(e.longValue());
	System.out.println(e.shortValue());

	List<Integer> integers = new LinkedList<Integer>();
	for (int i = 0; i < 5; ++i)
	    integers.add(i); // autoboxing int -> Integer
	
	int primitiveValue;
	for (Integer objValue: integers)
	    primitiveValue = objValue; // unboxing Integer -> int
   }
}

