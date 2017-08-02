// Compile with compact profile 1 to receive an error - javax.xml is not a part of compact profile 1
// javac -profile compact1 CompactProfile.java
public class CompactProfiles {
    public static void main(String[] args) {
	String text = javax.xml.XMLConstants.NULL_NS_URI;
    }
}
