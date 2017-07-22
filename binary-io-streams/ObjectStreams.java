import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.EOFException;
import java.util.Arrays;

class ObjectStreams {
    public static void main(String[] args) {
	byteByByte();
    }
    
    static void byteByByte() {
	System.out.println("Writing objects to object stream:");
	byte[] data = null;
	try (	ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream)) {
		
		MyClass obj = new MyClass();
		obj.x = 11;
		obj.y = 22;
		obj.z = "Hello, world!";
		obj.w.a = 33;
		obj.w.b = "Hello again!";

		objectOutputStream.writeObject(obj);

		// some more objects
		objectOutputStream.writeObject(new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		objectOutputStream.writeObject(new Boolean(true));
		objectOutputStream.writeObject(new Byte((byte)42));
		data = byteOutputStream.toByteArray();
		System.out.println("Written " + byteOutputStream.toByteArray().length + " bytes");
		System.out.println("Data: " + Arrays.toString(byteOutputStream.toByteArray()));
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();

	System.out.println("Reading objects from object stream:");
	try (	InputStream byteInputStream = new ByteArrayInputStream(data);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream)) {
	    while (true) {
		Object obj = objectInputStream.readObject();
		System.out.println(obj.getClass() + ", " + obj);
	    }
	}
	catch (EOFException ex) {
	    System.out.println("End of stream");
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();
    }
}

// must implement Serializable
class MyClass implements Serializable {
    @Override
    public String toString() {return "{x:" + x + ", y:" + y +  ", z:\"" + z + "\"" + ", w:" + w + "}";}
    public int x;
    public transient Integer y; // will be ignored by serialization
    public String z;
    public TestData w = new TestData();
}

// must be Serializable, too
class TestData implements Serializable {
    @Override
    public String toString() {return "{a:" + a + ", b:\"" + b + "\"}";}
    public int a;
    public String b;
}
