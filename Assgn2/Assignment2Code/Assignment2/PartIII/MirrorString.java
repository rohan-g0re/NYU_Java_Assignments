public class MirrorString {

    /**
     * Return the input followed by its reverse.
     * e.g. "hello" → "helloolleh"
     */
    public static String mirrorString(String input) {

        if (input == null) return null;              // safety check

        StringBuilder reverse = new StringBuilder(input).reverse();
        return input + reverse.toString();
    }

    public static void main(String[] args) {


    	
    	String[] tests = { "hello", "java", "a" };

        for (String s : tests) {
            System.out.println("Mirror of \"" + s + "\" is \"" + mirrorString(s) + "\"");
        }
    }
}
