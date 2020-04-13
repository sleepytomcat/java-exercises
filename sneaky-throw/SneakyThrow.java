import java.io.IOException; // checked exception

class SneakyThrow {
  static <T extends Throwable> void sneakyThrow(Throwable ex) throws T {
      throw (T) ex;
  }

  static void noCheckedExceptionsDeclared() {
      sneakyThrow(new IOException()); // checked exception
  }

  public static void main(String[] args) {
    try {
	noCheckedExceptionsDeclared();
    } catch (Throwable ex) {
	System.out.println(ex); // checked IOException will be logged
    }
  }
}
