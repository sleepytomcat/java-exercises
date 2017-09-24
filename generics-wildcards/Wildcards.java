import java.util.List;
import java.util.ArrayList;

public class Wildcards {
    public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
	for(int i = 0; i < 3; ++i)
	    list.add(i);

	foo(list);
	bar(list);
	bar(list);
	foobar(list);

	List<List<Integer>> listoflists = new ArrayList<>();
	barfoo(listoflists);
    }

    static void foo(List<?> list) {
	for (Object obj: list) {
	    System.out.println(obj);
	}
    }

    static <T> void bar(List<T> list) {
	for (T obj: list) {
	    System.out.println(obj);
	}
    }
    
    static <T> void foobar(List<T> list) {
	foo(list);
    }

    static void barfoo(List<? extends List<?>> listoflists) {
    }
}
