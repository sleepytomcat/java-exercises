package pkg.subPkg;
// Java Language 8 Specification:
// "A simple name may occur in contexts where it may potentially be interpreted as the name of a variable, 
// a type, or a package. In these situations, the rules of §6.5 specify that a variable will be chosen 
// in preference to a type, and that a type will be chosen in preference to a package. 
// Thus, it is may sometimes be impossible to refer to a visible type or package declaration 
// via its simple name. We say that such a declaration is obscured."
//
// In this case, package name pkg.subPkg is obscured by the class with the same name pkg.subPkg. 
public class myClass {
}
