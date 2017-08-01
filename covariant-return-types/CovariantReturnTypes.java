public class CovariantReturnTypes {
    public static void main(String[] args) {
	ShapeGenerator generator = new TriangleGenerator();
	Shape obj = generator.generate();
	System.out.println("Actual type of returned object is " 
		+ obj.getClass().getName());
    }
}

class Shape {}
class Triangle extends Shape {}

class ShapeGenerator {
    Shape generate() {return new Shape();}
}

class TriangleGenerator extends ShapeGenerator {
    // It's Ok to return co-variant type 
    // when overriding a method of base class
    @Override
    Triangle generate() {return new Triangle();}
}

