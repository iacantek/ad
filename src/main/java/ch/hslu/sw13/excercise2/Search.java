package ch.hslu.sw13.excercise2;

public class Search {
    private static final String PATTERN = "ANANAS";

    public static int stateSearch(final String a) {
        if (a == null || a.isEmpty()) {
            return -1;
        }

        int patternIndex = 0;
        for (int i = 0; i < a.length(); i++) {
            if (PATTERN.charAt(patternIndex) == a.charAt(i)) {
                if (patternIndex == PATTERN.length() - 1) {
                    return i - PATTERN.length() + 1; // pattern found
                }
                patternIndex++;
            }
            else {
                if (PATTERN.charAt(patternIndex) == 'A') {
                    patternIndex = 1;
                }
                else if (PATTERN.charAt(patternIndex) == 'N' && patternIndex == PATTERN.length() - 1) {
                    patternIndex = 3;
                }
                else {
                    patternIndex = 0;
                }
            }
        }
        return -1;
    }
}
