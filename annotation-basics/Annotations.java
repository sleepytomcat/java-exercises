public class Annotations {   
}

// **********************
@interface MyAnnotation {
}

@MyAnnotation // 'marker annotation', no params
class Test {
}

// **********************
@interface MyAnnotationWithParam {
    int param();
}

@MyAnnotationWithParam(param = 10)
class Test2 {
}

// **********************
@interface MyAnnotationWithDefaultParam {
   int param() default 100;
}

@MyAnnotationWithDefaultParam
class Test3 {
}

// **********************
@interface MyAnnotationWithValueParam {
   int value(); // 'value' is a default acceptor for anonymous values (see below)
}

// anonymous annotation param would be sent to 'value' by the compiler
// (so 'value' method must be explicitly declared, see above)
@MyAnnotationWithValueParam(128) 
class Test4 {
}


// **********************
enum Options { ONE, TWO, THREE }

@interface MyAnnotationWithAllPossibleParamTypes {
    // primitive types
    boolean booleanParam();
    byte    byteParam();
    char    charParam();
    short   shortParam();
    int     intParam();
    long    longParam();
    float   floatParam();
    double  doubleParam();

    String  StringParam(); // String 
    Class   ClassParam(); // Class
    Options enumParam(); // Enum
    MyAnnotation annotationParam(); // Annotation

    // arrays of all of the above
    // (which implicitly prohibits arrays of arrays)
    boolean[] booleanParamArray();
    byte[]    byteParamArray();
    char[]    charParamArray();
    short[]   shortParamArray();
    int[]     intParamArray();
    long[]    longParamArray();
    float[]   floatParamArray();
    double[]  doubleParamArray();
    String[]  StringParamArray();
    Class[]   ClassParamArray();
    Options[] enumParamArray();
    MyAnnotation[] annotationParamArray();
}
