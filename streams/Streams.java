import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Streams {
    static void print(List<Integer> numbers) {
	for (Integer number: numbers) {
	    System.out.println(number);
	}
    }

    static void print_stream(List<Integer> numbers) {
	numbers.stream().forEach(System.out::println);
    }

    static List<Integer> selectEvenNumbers(List<Integer> numbers) {
	List<Integer> evenNumbers = new LinkedList<>(); 	
	for (Integer number: numbers) {
	    if (number % 2 == 0) {
		evenNumbers.add(number);
	    }
	}
	return evenNumbers;
    }

    static List<Integer> selectEvenNumbers_stream(List<Integer> numbers) {
	return numbers.stream()
	    .filter(number -> number % 2 == 0)
	    .collect(Collectors.toList());
    }

    static long countEvenNumbers(List<Integer> numbers) {
	long counter = 0;
	for (Integer number: numbers) {
	    if (number % 2 == 0) {
		counter++;
	    }
	}
	return counter;
    }

    static long countEvenNumbers_stream(List<Integer> numbers) {
	return numbers.stream()
	    .filter(number -> number % 2 == 0)
	    .count();
    }

    static boolean checkIfAllEven(List<Integer> numbers) {
	boolean result = true;
	for (Integer number: numbers) {
	    if (number % 2 != 0) {
		result = false;
	    }
	}
	return result;
    }

    static boolean checkIfAllEven_stream(List<Integer> numbers) {
	return numbers.stream().allMatch(number -> number % 2 == 0);
    }

    static List<Integer> selectDistinct(List<Integer> numbers) {
	Set<Integer> set = new HashSet<Integer>();
	set.addAll(numbers);
	List<Integer> result = new LinkedList<Integer>();
	result.addAll(set);
	return result;	
    }

    static List<Integer> selectDistinct_stream(List<Integer> numbers) {
	return numbers.stream()
	    .distinct()
	    .collect(Collectors.toList());
    }

    static Map<Integer, List<String>> groupStringByLength(List<String> strings) {
	Map<Integer, List<String>> groupedStrings = new HashMap<>();
	for (String string: strings) {
	    int length = string.length();
	    if (!groupedStrings.containsKey(length)){
		List<String> bucket = new LinkedList<>();
		bucket.add(string);
		groupedStrings.put(length, bucket);
	    }	    
	    else {
		groupedStrings.get(length).add(string);
	    }
	}
	return groupedStrings;
    }

    static Map<Integer, List<String>> groupStringsByLength_stream(List<String> strings) {
	return strings.stream().collect(Collectors.groupingBy(String::length));
    }

    static List<String> flatten(List<List<String>> listOfLists) {
	List<String> result = new LinkedList<>();
	for (List<String> list: listOfLists) {
	    result.addAll(list);
	}
	return result;
    }

    static List<String> flatten_stream(List<List<String>> listOfLists) {
	return listOfLists.stream()
	    .flatMap(List::stream)
	    .collect(Collectors.toList());
    }

    static void lazyEvaluation_stream(List<Integer> indexes, int noMoreThan) {
	indexes.stream()
	    .peek(value -> System.out.println("...computing " + value.toString()))
	    .limit(noMoreThan)
	    .collect(Collectors.toList());
    }
}
