package reflections;

class X<T> {
    public void setData(T value) {
	data = value;
    }

    private T data;
}

public class main {
    public static void main(String[] args) {
	TypeExplorer.printClassDescription(int[].class, System.out);
	TypeExplorer.printClassDescription(Object.class, System.out);
    }
}
