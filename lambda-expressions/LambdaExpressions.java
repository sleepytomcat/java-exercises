public class LambdaExpressions {
    public static void main(String[] args) {
	String localData = "local-data"; // should be final or effectively final to be accessible within lambda, below
	LambdaExpressions obj = new LambdaExpressions();
	
	// using lambda expression in-place
	obj.apply(text -> {
		System.out.println("In-place lambda expression can access received '" + text + "'");
		System.out.println("In-place lambda expression can also access local variables, i.e. '" + localData + "'");
	});

	// assigning lambda expression to a functor
	Func1arg functor = str -> System.out.println("Lambda expression assigned to variable, then applied to '" 
							+ str + "' and '" + localData + "'");
	obj.apply(functor);
    
	// using instance methods as lambda
	System.out.println("Passing object method in place of lambda:");
	obj.apply((Func1arg)(System.out::println));
	
	System.out.println("Passing class static method in place of lambda");
	obj.apply(LambdaExpressions::f);

	// lambda expression with several arguments
	obj.apply((a, b, c) -> System.out.println("Lambda with multiple arguments:'" + a + "+" + b + "+" + c + "'"));

	// also, lambda expression can have zero arguments
	obj.apply(()->{System.out.println("Lambda may have zero arguments");});

	// lambda expressions may be assigned to variables
	Func0args zeroArgs = ()->{};
	Func1arg oneArg = str->{};
	Func3args threeArgs = (x,y,z)->{};
	obj.apply(zeroArgs);
	obj.apply(oneArg);
	obj.apply(threeArgs);

	obj.doAdd((a,b) -> a+b); // simplified form for lambda expressions returning a value
	obj.doAdd((a,b) -> {return a + b;}); // 'regular' form
    }

    void apply(Func1arg f) {f.process("lambda-argument");}
    void apply(Func0args f) {f.process();}
    void apply(Func3args f) {f.process("prefix", "text", "postfix");}
    void doAdd(Summation f) {System.out.println("1 + 2 = " + f.sum(1,2));}

    static void f(String text) {};
}

@FunctionalInterface // interface should provide exactly one abstract method (default methods do not count)
interface Func1arg {
    void process(String textToProcess);
}

@FunctionalInterface
interface Func0args {
    void process();
}

@FunctionalInterface 
interface Func3args {
    void process(String prefix, String text, String suffic);
}

@FunctionalInterface
interface Summation {
    int sum(int a, int b);
}
