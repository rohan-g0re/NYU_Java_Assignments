public class Acronym {

    /**
     * Convert a sentence to its acronym.
     * Words are separated by spaces; first letters are upper-cased.
     *
     * @param input full sentence
     * @return acronym in upper-case (e.g., "as soon as possible" → "ASAP")
     */
    public static String createAcronym(String input) {

        if (input == null || input.isEmpty()) return "";

        StringBuilder acronym = new StringBuilder();
        String[] words = input.trim().split(" +");   // one or more spaces

        for (String w : words) {
            // ignore empty strings that can appear if there are extra spaces
            if (!w.isEmpty())
                acronym.append(Character.toUpperCase(w.charAt(0)));
        }
        return acronym.toString();
    }

    public static void main(String[] args) {

        String s1 = "as soon as possible";
        String s2 = "The quick brown fox jumps over the lazy dog";

        System.out.println("Input : " + s1);
        System.out.println("Acronym: " + createAcronym(s1));

        System.out.println("\nInput : " + s2);
        System.out.println("Acronym: " + createAcronym(s2));
    }
}
