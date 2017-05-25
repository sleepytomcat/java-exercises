public class Inheritance {
    public static void main(String[] args) {
	BaseClass obj = new DerivedClass(42);
	obj.f();

	Colored figure = new ColoredCircle(10.1f, 20.3f, 1);
	figure.setColor(Colored.green);
    }
}

class BaseClass {
    BaseClass(int data) {
	this.data = data; // 'final' field can be initialized in constructor
    }

    void f() {
	System.out.println("BaseClass.f() displays BaseClass.data value, which is " + data);
    }
    private final int data;
}

class DerivedClass extends BaseClass {
    DerivedClass(int data) {
	super(data); // base class can be initialized in constructor; first statement only
    }

    @Override // optional, but informs compiler and helps detect errors
    void f() {
	System.out.println("DerivedClass overrides BaseClass.f(), but calls it using 'super' keyword");
	super.f();
    }
}

// must use 'abstract' keyword, as this class has abstract method(s) 
abstract class Shape {
    private float x;
    private float y;
    Shape(float x, float y) {
	this.x = x;
	this.y = y;
    }

    // 'abstract' methods does not provide implementation 
    abstract float calculateArea();
}

// adding 'final' here would prohibit any subclasses of Circle
class Circle extends Shape {
    // must provide constructor and pass parameters to 'super' as Shape has only parametrised constructor
    Circle(float x, float y) {
	super(x, y);
    }
    private float radius;
    // 'final' prohibits overriding of this method in derived classes
    final float calculateArea() {
	return 3.14f * radius * radius;
    }
}

interface Colored {
    void setColor(int color); // implicitly declared public, and there's no other option
    default int getColor() {return 0;} // default implementation; can use only static data, as interfaces do not have state
    int red = 1; // implicitly declared public static final
    int green = 2;
    int blue = 3;
}

class ColoredCircle extends Circle implements Colored {
    ColoredCircle(float x, float y, int color) {
	super(x, y);
	this.color = color;
    }

    // note 'public'
    public void setColor(int color) {
	this.color = color;
    }

    public int getColor() {
	return color;
    }

    private int color;
}

