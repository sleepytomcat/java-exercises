class Partial {
    public static void main(String[] args) {
	TwoMethods obj = new FullyImplemented();
    }
}

interface TwoMethods {
    void methodOne();
    void methodTwo();
}

// 'abstract' because this class does not implement all interface methods
abstract class PartiallyImplemented implements TwoMethods {
    public void methodOne() {
    }
}

class FullyImplemented extends PartiallyImplemented {
    public void methodTwo() {
    }
}
