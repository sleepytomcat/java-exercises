package reflections;

import java.io.PrintStream;
import java.lang.Package;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.LinkedList;

public class TypeExplorer {
    public static void printClassDescription(Class classObject, PrintStream stream) {
	stream.println("type '" + classObject.getCanonicalName() + "'");
	stream.println(indent + "simple name: '" + classObject.getSimpleName() + "'");
	stream.println(indent + "type name: '" + classObject.getTypeName() + "'");
	stream.println(indent + "internal name: '" + classObject.getName() + "'");

	int modifiers = classObject.getModifiers();
	String modifiersDescription = generateModifiersDescription(modifiers);
	Package pkg = classObject.getPackage();
	Annotation[] annotations = classObject.getAnnotations();
	Method[] methods = classObject.getMethods();
	Field[] fields = classObject.getFields();
	
	printModifiersDescription(modifiers, stream, indent);
	printAnnotationsDescription(annotations, stream, indent);
	printPackageDescription(pkg, stream, indent);
	printMethodsDescription(methods, stream, indent);
	printFieldsDescription(fields, stream, indent);
    }

    private static void printModifiersDescription(int modifiers, PrintStream stream, String indent) {
	String modifiersDescription = generateModifiersDescription(modifiers);

	if (modifiersDescription == null || modifiersDescription.length() == 0)
	    stream.println(indent + "modifiers: <none>");
	else
	    stream.println(indent + "modifiers: " + modifiersDescription);
    }

    private static String generateModifiersDescription(int modifiers) {
	List<String> modifiersList = new LinkedList<String>();

	if (Modifier.isAbstract(modifiers))
	    modifiersList.add("abstract");

	if (Modifier.isFinal(modifiers))
	    modifiersList.add("final");
	
	if (Modifier.isInterface(modifiers))
	    modifiersList.add("interface");
	
	if (Modifier.isNative(modifiers))
	    modifiersList.add("native");
	
	if (Modifier.isPrivate(modifiers))
	    modifiersList.add("private");
	
	if (Modifier.isProtected(modifiers))
	    modifiersList.add("protected");
	
	if (Modifier.isPublic(modifiers))
	    modifiersList.add("public");
	
	if (Modifier.isStatic(modifiers))
	    modifiersList.add("static");
	
	if (Modifier.isStrict(modifiers))
	    modifiersList.add("strict");
	
	if (Modifier.isSynchronized(modifiers))
	    modifiersList.add("synchronized");
	
	if (Modifier.isTransient(modifiers))
	    modifiersList.add("transient");

	if (Modifier.isVolatile(modifiers))
	    modifiersList.add("volatile");

	return String.join(", ", modifiersList);
    }

    private static void printPackageDescription(Package pkg, PrintStream stream, String indent) {
	if (pkg == null)
	    stream.println(indent + "package: <none>");
	else {
	    String name = pkg.getName();
	    String specificationTitle = pkg.getSpecificationTitle();
	    String specificationVendor = pkg.getSpecificationVendor();
	    String implementationTitle = pkg.getImplementationTitle();
	    String implementationVendor = pkg.getImplementationVendor();
	    Annotation[] annotations = pkg.getAnnotations();

	    stream.println(indent + "package: '" + name + "'");
	    String subIndent = indent + indent;
	    printAnnotationsDescription(annotations, stream, subIndent);
	    stream.println(subIndent + "specification: '" + specificationTitle + "'");
	    stream.println(subIndent + "specification vendor: '" + specificationVendor + "'");
	    stream.println(subIndent + "implementation: '" + implementationTitle + "'");
	    stream.println(subIndent + "implementation vendor: '" + implementationVendor + "'");
	}
    }

    private static void printAnnotationsDescription(Annotation[] annotations, PrintStream stream, String indent) {
	if (annotations == null || annotations.length == 0)
	    stream.println(indent + "annotations: <none>");
	else {
	    stream.println(indent + "annotations:");
	    String subIndent = indent + indent;
	    for (Annotation annotation: annotations) {
		stream.println(subIndent + annotation);
	    }
	}
    }

    private static void printMethodsDescription(Method[] methods, PrintStream stream, String indent) {
	if (methods == null || methods.length == 0)
	    stream.println(indent + "methods: <none>");
	else {
	    stream.println(indent + "methods:");
	    String subIndent = indent + indent;
	    for (Method method: methods) {
		Annotation[] annotations = method.getAnnotations();
		stream.println(subIndent + method);
		printAnnotationsDescription(annotations, stream, subIndent);
	    }
	}
    }

    private static void printFieldsDescription(Field[] fields, PrintStream stream, String indent) {
	if (fields == null || fields.length == 0)
	    stream.println(indent + "fields: <none>");
	else {
	    stream.println(indent + "fields:");
	    String subIndent = indent + indent;
	    for (Field field: fields) {
		stream.println(subIndent + field);
	    }
	}
    }

    private static String indent = "    ";
}
