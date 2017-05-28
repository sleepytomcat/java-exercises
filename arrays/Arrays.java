public class Arrays {
    public static void main(String[] args) {
	// Declarations
	int[] a; // recommended way to declare array
	int b[]; // not recommended way to declare arrays
	int[] c = {1,2,3,4}; // array initializer
	int[] d = new int[2]; // array dimensions required; values are 'by default'
	int[] e = new int[]{1,2,3}; // array dimensions come from initialization

	// Accessing array data
	for (int i = 0; i < c.length; ++i) // arrays define final 'length' field
	    System.out.println("c[" + i + "] is " + c[i]);
	
	for (int value: d)
	    System.out.println("value from d is " + value);

	// Arrays can store references to objects
	String greeting = "hello";
	String[] words = {greeting, "world"};
	for (String word: words)
	    System.out.println("word is " + word);

	// Arrays override Object.clone()
	int[] x = {5,7,9};
	int[] y = x.clone();

	for (int i = 0; i < y.length; ++i)
	    System.out.println("x[" + i + "] is " + x[i] + ", y[" + i + "] is " + y[i]);
 
	// Note: array clone() method provides shallow copy only
	Object[] objectArray = {new Object()}; // array with 1 element of ref type Object
	Object[] objectArrayCopy = objectArray.clone();
	System.out.println("(objectArray == objectArrayCopy) is " + (objectArray == objectArrayCopy) + ", as objectArrayCopy is a new object");
	System.out.println("(objectArray[0] == objectArrayCopy[0]) is " + (objectArray[0] == objectArrayCopy[0]) + ", as array clone() creates a shallow copy, and ref elements still point to shared objects");
    } 
}
