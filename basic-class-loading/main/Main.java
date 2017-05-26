package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	if (args.length != 1) {
	    printUsage();
	}
	else
	{
	    String classNameToLoad = args[0];
	    System.out.println("# loading executor class '" + classNameToLoad + "'");
	    try {
		ClassLoader loader = Main.class.getClassLoader();
		Class customExecutorClass = loader.loadClass(classNameToLoad);
		System.out.println("# class '" + classNameToLoad + "' successfully loaded");
		if (!ExecutorInterface.class.isAssignableFrom(customExecutorClass))
		    System.out.println("# error: custom executor class must implement main.ExecutorInnerface");
		else {
		    ExecutorInterface executor = (ExecutorInterface)customExecutorClass.newInstance();
		    System.out.println("# custom executor instantiated successfully");
		    int state = ExecutorInterface.CONTINUE;
		    Scanner consoleInput = new Scanner(System.in);
		    while (state == ExecutorInterface.CONTINUE) {
			System.out.print("# enter command and press Enter: ");
			String command = consoleInput.next();
			state = executor.process(command);
		    }
		}
	    }
	    catch (ClassNotFoundException e) {
		System.out.println("# error: class '" + classNameToLoad + "' not found");
	    }
	    catch (InstantiationException e) {
		System.out.println("# error: failed to instantiate custom executor object");
	    }
	    catch (IllegalAccessException e) {
		System.out.println("# error: class inaccessible");
	
	    }
	}
    }

    private static void printUsage() {
	System.out.println("Usage: java main.Main <custom executor class name>");
    }
}
