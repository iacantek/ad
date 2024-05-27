package ch.hslu.sw12.exercise7;

public class WordProblem {
    public static boolean isWordLanguage(final String string) {
        if (string == null || string.isEmpty() || string.charAt(0) == '1') {
            return false;
        }

        char[] chars = string.toCharArray();
        char prev = chars[0];
        int oneCount = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (prev == '0' || oneCount % 2 == 0) {
                    return false;
                }
                oneCount = 0;
            }
            else {
                if (i == chars.length - 1) {
                    return false;
                }
                oneCount++;
            }
            prev = chars[i];
        }

        return true;
    }

    public static boolean isWordLanguageRegex(final String string) {
        return string.matches("^0(1(11)*0)*");
    }
}
