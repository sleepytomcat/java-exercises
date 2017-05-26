package plugin;
public class CustomExecutor implements main.ExecutorInterface {
    public int process(String data) {
	if (data.equals("quit"))
	    return main.ExecutorInterface.FINISH;
	else {
	    System.out.println("@ custom executor processed '" + data + "' [enter 'quit' to exit]");
	    return main.ExecutorInterface.CONTINUE;
	}
    }
}
