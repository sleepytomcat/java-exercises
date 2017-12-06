import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 5, 7, 3, 3);
	
	System.out.println("Print numbers, for loop");
	Streams.print(numbers);
	System.out.println("Print numbers, stream");
	Streams.print_stream(numbers);
	
	System.out.println("Select even numbers, for loop");
	Streams.selectEvenNumbers(numbers).forEach(System.out::println);
	System.out.println("Select even numbers, stream");
	Streams.selectEvenNumbers_stream(numbers).forEach(System.out::println);
	
	System.out.println("Count even numbers, for loop");
	System.out.println(Streams.countEvenNumbers(numbers));
	System.out.println("Count even numbers, stream");
	System.out.println(Streams.countEvenNumbers_stream(numbers));
	
	System.out.println("Check if all even, for loop");
	System.out.println(Streams.checkIfAllEven(numbers));
	System.out.println("Check if all even, stream");
	System.out.println(Streams.checkIfAllEven_stream(numbers));

	System.out.println("Select distinct numbers, for loop");
	Streams.selectDistinct(numbers).forEach(System.out::println);
	System.out.println("Select distinct numbers, stream");
	Streams.selectDistinct_stream(numbers).forEach(System.out::println);
	
	List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
	System.out.println("Group strings by length, for loop");
	Streams.groupStringByLength(strings).forEach((key, value) -> 
		System.out.println(key + ":" + value)
	);
	System.out.println("Group strings by length, stream");
	Streams.groupStringsByLength_stream(strings).forEach((key, value) ->
		System.out.println(key + ":" + value)
	);
	List<List<String>> listOfLists = new LinkedList<>();
	listOfLists.add(Arrays.asList("1", "2", "3"));
	listOfLists.add(Arrays.asList("4", "5", "6"));
	System.out.println("Flatten list of numbers, for loop");
	Streams.flatten(listOfLists).forEach(System.out::println);
	System.out.println("Flatten list of numbers, stream");
	Streams.flatten_stream(listOfLists).forEach(System.out::println);
    }
}
