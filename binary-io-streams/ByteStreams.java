import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;

class ByteStreams {
    public static void main(String[] args) {
	byteByByte();
	withByteBuffer();
    }
    
    static void byteByByte() {
	System.out.println("Writing bytes to binary stream, byte by byte:");
	try (OutputStream outputStream = new FileOutputStream("test.data")) {
	    for (int value = -128; value <= 127; ++value) {
		System.out.print(value + " ");
		outputStream.write(value);
	    }
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();

	System.out.println("Reading bytes from binary stream, byte by byte:");
	try (InputStream inputStream = new FileInputStream("test.data")) {
	    int valueRead = 0;
	    // InputStream.read() returns int value which can contain 
	    // or binary representation of byte which is read from the stream,
	    // or -1 which means 'end of stream'.
	    // Converting the int value to byte yields the actual byte read from stream.
	    while ((valueRead = inputStream.read()) != -1)
		System.out.print((byte)valueRead + " ");
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	System.out.println();
    }

    static void withByteBuffer() {
	System.out.println("Writing bytes to binary stream, from byte buffer:");
	try (OutputStream outputStream = new FileOutputStream("test.data")) {
	    byte[] buffer = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
	    System.out.println("Buffer: " + Arrays.toString(buffer));
	    outputStream.write(buffer, 3, 5); // expected to write -2, -1, 0, 1, 2
	    System.out.println("Writing {-2, -1, 0, 1, 2} to stream");
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
	
	System.out.println("Reading bytes from binary stream, to byte buffer:");
	try (InputStream inputStream = new FileInputStream("test.data")) {
		byte[] buffer = {0,0,0,0,0,0,0,0,0,0,0};
		System.out.println("Buffer before reading: " + Arrays.toString(buffer));
		int bytesRead = inputStream.read(buffer, 3, 5);
		System.out.println("Bytes read: " + bytesRead);
		System.out.println("Buffer after reading: " + Arrays.toString(buffer));
	}
	catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}
