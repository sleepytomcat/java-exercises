class finalDeclaration {
    final int x = 10;
    final int y;
    int z;
    finalDeclaration() {
	y = 25; // OK to initialize in constructor
    }

    public static void main(String[] args) {
	final finalDeclaration obj = new finalDeclaration();
	// obj  = null; // cannot change final data
	// obj.y = 15; // cannot change final data
	obj.z = 100; // Ok, as obj.z is not 'final' (while obj itself is 'final')
    }
}
