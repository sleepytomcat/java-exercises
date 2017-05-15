class finalDeclaration {
    final int x = 10;
    final int y;
    finalDeclaration() {
	y = 25; // OK to initialize in constructor
    }

    public static void main(String[] args) {
	finalDeclaration obj = new finalDeclaration();
	// obj.y = 15; // cannot change final data
    }
}
