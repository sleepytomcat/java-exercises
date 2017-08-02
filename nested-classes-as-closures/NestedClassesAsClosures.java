public class NestedClassesAsClosures {
    public static void main(String[] args) {
	MessageProcessor processor = new MessageProcessor();
	MessageProcessor.MessagePipe pipe1 = processor.getPipe("pipe-1");
	MessageProcessor.MessagePipe pipe2 = processor.getPipe("pipe-2");

	pipe1.sendMessage("hello");
	pipe2.sendMessage("world");
    }
}

class MessageProcessor {
    MessagePipe getPipe(String pipeName) {
	return new MessagePipe(pipeName);
    }

    class MessagePipe {
	MessagePipe(String pipeName) {
	    this.pipeName = pipeName;
	}

	void sendMessage(String text) {
	    processMessage(pipeName, text); // note that nested class has access to parent class fields and methods
	}

	private final String pipeName;
    }

    private void processMessage(String source, String msg) {
	System.out.println("pipe: '" + source + "', message: '" + msg + "'");
    }
}
