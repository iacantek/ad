package ch.hslu.sw13.excercise5;

public class Search {
    /**
     * Durchsucht eine Zeichenkette mittels quickSearch.
     *
     * @param a Zeichenkette, die durchsucht wird.
     * @return Index der Fundstelle oder -1, falls Pattern in a nicht gefunden wurde.
     */
    public static int quickSearch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + j) == p.charAt(j)) { // match
                j++;
            } else { // mismatch
                if ((i + m) < n) { // a.charAt(i1+m) is not outside a
                    i += shift[a.charAt(i + m)]; // jump forward
                    j = 0;
                } else {
                    break; // (mismatch) && (no shift is possible)
                }
            }
        } while ((j < m) && ((i + m) <= n));
        // (position at i not completely checked) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }

    public static int quickSearchWithOptimalMismatch(final String a, final String p) {
        final int n = a.length();
        final int m = p.length();
        final int range = 256; // -> ASCII-Range
        final int[] shift = new int[range];
        // init shift-array
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        // overwrite fields according pattern
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        String optimalPattern = p;
        int i = 0; // index to string
        int j = 0; // index to pattern p
        do {
            if (a.charAt(i + p.indexOf(optimalPattern.charAt(j))) == optimalPattern.charAt(j)) {
                j++;
            }
            else if (i + j < m) {
                optimalPattern = swap(optimalPattern, p.charAt(j));
                i += shift[a.charAt(i + m)]; // jump forward
                j = 0;
            }
        } while ((j < m) && ((i + m) <= n));
        // (position at i not completely checked) && (end of a not reached)
        if (j == m) {
            return i; // pattern found
        } else {
            return -1; // pattern not found
        }
    }

    private static String swap(String optimalPattern, char c) {
        int indexOfMismatch = optimalPattern.indexOf(c);
        char[] optimalPatternArray = optimalPattern.toCharArray();
        if (indexOfMismatch != 0) {
            char temp = optimalPatternArray[indexOfMismatch];
            optimalPatternArray[indexOfMismatch] = optimalPatternArray[indexOfMismatch - 1];
            optimalPatternArray[indexOfMismatch - 1] = temp;
        }

        return new String(optimalPatternArray);
    }
}
