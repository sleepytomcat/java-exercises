import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

class ByteArrayStreams {
    public static void main(String[] args) {
	System.out.println("Writing bytes:");
	try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
	    for (int value = (int)'A'; value <= (byte)'F'; ++value) {
		System.out.print(value + " ");
		outputStream.write(value);
	    }
	
	    System.out.println();
	    System.out.println("Stream's buffer size is " + outputStream.size());
	    byte[] buffer = outputStream.toByteArray(); // creates a copy of stream's buffer
	    System.out.println("Stream's buffer data as string, using default charset: " + outputStream.toString());
	    System.out.println("Stream's buffer data as string, using ASCII encoding: " + outputStream.toString("ASCII"));
	    System.out.println("Now sending stream's data to another output stream:");
	    outputStream.writeTo(System.out);
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}

	System.out.println();
	System.out.println("Reading bytes:");
	byte[] buffer = {1,2,3,4,5,6,7};
	try (InputStream inputStream = new ByteArrayInputStream(buffer)) {
	    int valueRead = 0;
	    while ((valueRead = inputStream.read()) != -1)
		System.out.print((byte)valueRead + " ");
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
