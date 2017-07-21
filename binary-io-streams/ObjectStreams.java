import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
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
		
		objectOutputStream.writeObject(new String("Hello, world!")); // String object
		data = byteOutputStream.toByteArray();
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();

	System.out.println("Reading objects from object streame:");
	try (	InputStream byteInputStream = new ByteArrayInputStream(data);
		ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream)) {
	    Object x = objectInputStream.readObject();
	    System.out.println(x);
	x = objectInputStream.readObject();
	    System.out.println(x);
x = objectInputStream.readObject();
	    System.out.println(x);
}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();
    }
}
