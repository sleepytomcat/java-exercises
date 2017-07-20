package reflections;

class X<T> {
    public void setData(T value) {
	data = value;
    }

    private T data;
}

public class main {
    public static void main(String[] args) {
	X<Integer> obj = new X<Integer>();
	TypeExplorer.printClassDescription(obj.getClass(), System.out);
    }
}
